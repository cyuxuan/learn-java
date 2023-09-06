#! /bin/bash
#
# Copyright ©2023-2023 BeeNest Club. All rights reserved.
#
# centos已停止维护，执行下面的命令将镜像更改为vault.centos.org
cd /etc/yum.repos.d/
sed -i 's/mirrorlist/#mirrorlist/g' /etc/yum.repos.d/CentOS-*
sed -i 's|#baseurl=http://mirror.centos.org|baseurl=http://vault.centos.org|g' /etc/yum.repos.d/CentOS-*
# yum update -y




# 切换国内镜像
# 进入root，切换至yum.repos.d目录
cd /etc/yum.repos.d/
# 创建新文件夹并将源文件备份为repo.bak
mkdir backup && mv *repo backup/
# 下载国内yum源文件
curl -o /etc/yum.repos.d/CentOS-Base.repo http://mirrors.aliyun.com/repo/Centos-8.repo
# 更新下载yum源地址
sed -i -e"s|mirrors.cloud.aliyuncs.com|mirrors.aliyun.com|g " /etc/yum.repos.d/CentOS-*
sed -i -e "s|releasever|releasever-stream|g" /etc/yum.repos.d/CentOS-*
# 生成缓存
yum clean all && yum makecache



# 更新工具集
yum install -y yum-utils


# 卸载podman
sudo yum remove podman

# 卸载旧的docker
sudo yum remove docker docker-client docker-client-latest docker-common docker-latest docker-latest-logrotate docker-logrotate docker-engine


# 安装docker的yum源
sudo yum-config-manager --add-repo http://mirrors.aliyun.com/docker-ce/linux/centos/docker-ce.repo

# 安装docker
#sudo yum install -y docker-ce docker-ce-cli containerd.io
# --allowerasing允许升级冲突包到新版本
yum install --allowerasing -y docker-ce-20.10.7 docker-ce-cli-20.10.7  containerd.io-1.4.6

# docker开机自启
systemctl enable docker --now

# 阿里云镜像加速-暂时没有执行这个配置
sudo tee /etc/docker/daemon.json <<-'EOF'
{
  "registry-mirrors": ["https://hmar1alx.mirror.aliyuncs.com"],
  "exec-opts": ["native.cgroupdriver=systemd"],
  "log-driver": "json-file",
  "log-opts": {
    "max-size": "100m"
  },
  "storage-driver": "overlay2"
}
EOF

## 配置生效
sudo systemctl daemon-reload
sudo systemctl restart docker


# 检查主机名称，不可以重复
hostname

# 检查mac地址，不可以重复

# 检查product_uuid，不可以重复
cat /proc/sys/kernel/random/uuid

# 关闭防火墙
systemctl stop firewalld
systemctl disable firewalld

# 关闭selinux
setenforce 0
sed -i 's/^SELINUX=enforcing$/SELINUX=disabled/' /etc/selinux/config

# 关闭swap
swapoff -a
sed -ri 's/.*swap.*/#&/' /etc/fstab

#允许 iptables 检查桥接流量
cat <<EOF | sudo tee /etc/modules-load.d/k8s.conf
br_netfilter
EOF

cat <<EOF | sudo tee /etc/sysctl.d/k8s.conf
net.bridge.bridge-nf-call-ip6tables = 1
net.bridge.bridge-nf-call-iptables = 1
EOF






## k8s镜像地址
cat <<EOF | sudo tee /etc/yum.repos.d/kubernetes.repo
[kubernetes]
name=Kubernetes
baseurl=http://mirrors.aliyun.com/kubernetes/yum/repos/kubernetes-el7-x86_64
enabled=1
gpgcheck=0
repo_gpgcheck=0
gpgkey=http://mirrors.aliyun.com/kubernetes/yum/doc/yum-key.gpg
   http://mirrors.aliyun.com/kubernetes/yum/doc/rpm-package-key.gpg
exclude=kubelet kubeadm kubectl
EOF


## 安装k8s
sudo yum install -y kubelet-1.20.9 kubeadm-1.20.9 kubectl-1.20.9 --disableexcludes=kubernetes

## 启动kubelet
sudo systemctl enable --now kubelet


sudo tee ./images.sh <<-'EOF'
#!/bin/bash
images=(
kube-apiserver:v1.20.9
kube-proxy:v1.20.9
kube-controller-manager:v1.20.9
kube-scheduler:v1.20.9
coredns:1.7.0
etcd:3.4.13-0
pause:3.2
)
for imageName in ${images[@]} ; do
docker pull registry.cn-hangzhou.aliyuncs.com/cyuxuan/$imageName
done
EOF

chmod +x ./images.sh && ./images.sh

#所有机器添加master域名映射，以下需要修改为自己的
# 每一个节点都要知道master节点的位置
echo "10.8.0.10  cluster-endpoint" >> /etc/hosts
echo "10.8.0.10  local-centos8-k8s-master01" >> /etc/hosts
echo "10.8.0.11  local-centos8-k8s-node01" >> /etc/hosts
echo "10.8.0.12  local-centos8-k8s-node02" >> /etc/hosts
echo "10.8.0.13  local-centos8-k8s-node03" >> /etc/hosts


## 主节点初始化
#主节点初始化
kubeadm init \
--apiserver-advertise-address=10.8.0.10 \
--control-plane-endpoint=cluster-endpoint \
--image-repository registry.cn-hangzhou.aliyuncs.com/cyuxuan \
--kubernetes-version v1.20.9 \
--service-cidr=10.96.0.0/16 \
--pod-network-cidr=192.168.0.0/16

## 下面的数据在kubeadm init 初始化成功后的输出流中，注意保留输出信息
# mkdir -p $HOME/.kube
# sudo cp -i /etc/kubernetes/admin.conf $HOME/.kube/config
# sudo chown $(id -u):$(id -g) $HOME/.kube/config

##
# node
#kubeadm token create --print-join-command
#kubeadm token create --print-join-command
# master
#kubeadm init phase upload-certs --upload-certs

## 安装网络插件 calico
#curl https://docs.projectcalico.org/manifests/calico.yaml -O
wget https://docs.projectcalico.org/v3.20/manifests/calico.yaml --no-check-certificate

# 这里需要修改一下 calico 查找网卡的适配
#wget https://docs.projectcalico.org/v3.10/manifests/calico.yaml --no-check-certificate
kubectl apply -f calico.yaml

# # Auto-detect the BGP IP address.
#            - name: IP
#              value: "autodetect"
#            - name: IP_AUTODETECTION_METHOD
#              value: "interface={网卡名称，支持*匹配}"
#            # Enable IPIP
#            - name: CALICO_IPV4POOL_IPIP
#              value: "Always"

# kubectl get node local-centos8-master -o yaml | grep -i cidr
# vim /etc/kubernetes/manifests/kube-controller-manager.yaml
# kube-proxy --cluster-cidr=191.31.0.0/16
## 获取pod日志
#kubectl  logs -f -n kube-system calico-node-npdpv

## 部署k8s的dashboard
kubectl apply -f recommended.yaml

## 设置访问端口
## 打开配置
kubectl edit svc kubernetes-dashboard -n kubernetes-dashboard
## 修改配置 type: ClusterIP 改为 type: NodePort

kubectl get svc -A |grep kubernetes-dashboard
## 找到端口，在安全组放行
# 访问： https://集群任意IP:端口      https://139.198.165.238:32759
# 浏览器空白处输入 thisisunsafe


### 查看证书情况
#kubectl -n kubernetes-dashboard describe secret $(kubectl -n kubernetes-dashboard get secret | grep admin-user | awk '{print $1}')
#
#mkdir -pv /etc/kubernetes/pki/dashboard && cd /etc/kubernetes/pki/
#
#cp ca.crt ca.key dashboard/ && cd dashboard/
#
#(umask 077;openssl genrsa -out dashboard.key 2048)
#
#openssl req -new -key dashboard.key -out dashboard.csr -subj "/O=wangtianpei/CN=dashboard" #如果要用域名访问, CN一定要和域名保持一致
#
#openssl x509 -req -in dashboard.csr -CA ca.crt -CAkey ca.key -CAcreateserial -out dashboard.crt -days 3650
#
##拷贝到各个节点
#scp -r /etc/kubernetes/pki/dashboard/ local-centos8-k8s-node1:/etc/kubernetes/pki/
#scp -r /etc/kubernetes/pki/dashboard/ local-centos8-k8s-node2:/etc/kubernetes/pki/

## 获取dashboard的token
#kubectl get secret -n kube-system |grep dashboard-admin
#kubectl describe secret dashboard-admin-token-twrjp -n kube-system


#kubectl create serviceaccount kubernetes-dashboard-admin
#kubectl create clusterrolebinding kubernetes-dashboard-admin --serviceaccount=default:kubernetes-dashboard-admin --clusterrole=cluster-admin
#kubectl describe secret $(kubectl get secret -n default | grep kubernetes-dashboard-admin | awk '{print $1}')


# 新增用户及权限
# vi admin-user.yaml
# kubectl  apply  -f admin-user.yaml
# kubectl -n kubernetes-dashboard describe secret $(kubectl -n kubernetes-dashboard get secret | grep admin-user | awk ‘{print $1}’)

## 重新生成node密钥



kubeadm init phase upload-certs --upload-certs
kubeadm token create --print-join-command




d8a87e7a3e01be848e764e87f44d9261723fa80ab32ea5cdbe7407d4c0c43dff
kubeadm join cluster-endpoint:6443 --token nzi014.xuy79idugsjwolm4     --discovery-token-ca-cert-hash sha256:8d2a7cfce5774e45b7139bf4b0da6485f510bbd2a92a888502a513559d9841c1 --control-plane --certificate-key d8a87e7a3e01be848e764e87f44d9261723fa80ab32ea5cdbe7407d4c0c43dff














912f4ca2b4ad409645d7b2fb05477ec00ac44954fbd7174b7a758cb2a7dbed57

kubeadm join cluster-endpoint:6443 --token iehops.zagy3r1aprcjkw6h     --discovery-token-ca-cert-hash sha256:8d2a7cfce5774e45b7139bf4b0da6485f510bbd2a92a888502a513559d9841c1

kubeadm join cluster-endpoint:6443 --token iehops.zagy3r1aprcjkw6h     --discovery-token-ca-cert-hash sha256:8d2a7cfce5774e45b7139bf4b0da6485f510bbd2a92a888502a513559d9841c1 --control-plane --certificate-key 912f4ca2b4ad409645d7b2fb05477ec00ac44954fbd7174b7a758cb2a7dbed57
kubeadm join 172.16.0.1:6443       --token q466v0.hbk3qjreznjsf8ew     --discovery-token-ca-cert-hash xxxxxxx --control-plane --certificate-key xxxxxxx


kubectl -n kube-system get cm kubeadm-config -oyaml

kubectl -n kube-system edit cm kubeadm-config











kubeadm join cluster-endpoint:6443 --token 4re0t8.lyvyqfeemy4up6tr     --discovery-token-ca-cert-hash sha256:8d2a7cfce5774e45b7139bf4b0da6485f510bbd2a92a888502a513559d9841c1



















