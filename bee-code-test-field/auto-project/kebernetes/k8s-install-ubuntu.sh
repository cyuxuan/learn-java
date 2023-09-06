#! /bin/bash

# 永久修改机器名称
#sudo hostnamectl set-hostname local-ubuntu-

# 关闭防火墙
sudo ufw disable

## 一些初始化配置

# 初始化主机映射ip
echo "192.168.31.7 kube-node1" >>  /etc/hosts
echo "192.168.31.8 kube-node2" >>  /etc/hosts

## 将ipv4的流量传到iptables
cat > /etc/sysctl.d/k8s.conf << EOF
net.bridge.bridge-nf-call-ip6tables = 1
net.bridge.bridge-nf-call-iptables = 1
EOF


## 生效配置
sysctl --system

# 时间同步
apt-get install ntpdate -y
ntpdate time.windows.com
















# 安装docker
# 参考docker安装脚本

# 切换国内apt源
# https://blog.csdn.net/qq_21095573/article/details/99736630#:~:text=Ubuntu%20apt-get%20%E5%9B%BD%E5%86%85%E9%95%9C%E5%83%8F%E6%BA%90%E6%9B%BF%E6%8D%A2%20%28%E6%96%B0%E6%89%8B%E5%BF%85%E7%9C%8B%2C%E8%B6%85%E8%AF%A6%E7%BB%86%21%E5%90%84%E7%A7%8D%E9%95%9C%E5%83%8F%E6%BA%90%E7%BD%91%E7%AB%99%E9%83%BD%E6%9C%89%29%201%201.%E9%A6%96%E5%85%88%E8%BF%9B%E5%85%A5%E5%BC%80%E6%BA%90%E9%95%9C%E5%83%8F%E7%AB%99%E8%8E%B7%E5%8F%96%E7%9B%B8%E5%BA%94%E8%BF%9E%E6%8E%A5%2C%E8%BF%99%E9%87%8C%E4%BB%A5%E9%98%BF%E9%87%8C%E4%BA%91%E4%B8%BA%E4%BE%8B%3A%202%202.%E7%82%B9%E5%87%BBGlobal.help,5.%E6%9B%B4%E6%96%B0%E8%BD%AF%E4%BB%B6%E6%BA%90%E5%88%97%E8%A1%A8%20sudo%20apt-get%20update%20%23%E8%BF%99%E4%B8%AA%E5%91%BD%E4%BB%A4%EF%BC%8C%E4%BC%9A%E8%AE%BF%E9%97%AE%E6%BA%90%E5%88%97%E8%A1%A8%E9%87%8C%E7%9A%84%E6%AF%8F%E4%B8%AA%E7%BD%91%E5%9D%80%EF%BC%8C%E5%B9%B6%E8%AF%BB%E5%8F%96%E8%BD%AF%E4%BB%B6%E5%88%97%E8%A1%A8%EF%BC%8C%E7%84%B6%E5%90%8E%E4%BF%9D%E5%AD%98%E5%9C%A8%E6%9C%AC%E5%9C%B0%E7%94%B5%E8%84%91%E3%80%82%20%E6%88%91%E4%BB%AC%E5%9C%A8%E6%96%B0%E7%AB%8B%E5%BE%97%E8%BD%AF%E4%BB%B6%E5%8C%85%E7%AE%A1%E7%90%86%E5%99%A8%E9%87%8C%E7%9C%8B%E5%88%B0%E7%9A%84%E8%BD%AF%E4%BB%B6%E5%88%97%E8%A1%A8%EF%BC%8C%E9%83%BD%E6%98%AF%E9%80%9A%E8%BF%87update%E5%91%BD%E4%BB%A4%E6%9B%B4%E6%96%B0%E7%9A%84%E3%80%82%201%20

cp /etc/apt/sources.list /etc/apt/sources.list.bak

rm -rf /etc/apt/sources.list
touch /etc/apt/sources.list

cat>/etc/apt/sources.list<<EOF
# 默认注释了源码镜像以提高 apt update 速度，如有需要可自行取消注释
deb https://mirrors.tuna.tsinghua.edu.cn/ubuntu/ jammy main restricted universe multiverse
# deb-src https://mirrors.tuna.tsinghua.edu.cn/ubuntu/ jammy main restricted universe multiverse
deb https://mirrors.tuna.tsinghua.edu.cn/ubuntu/ jammy-updates main restricted universe multiverse
# deb-src https://mirrors.tuna.tsinghua.edu.cn/ubuntu/ jammy-updates main restricted universe multiverse
deb https://mirrors.tuna.tsinghua.edu.cn/ubuntu/ jammy-backports main restricted universe multiverse
# deb-src https://mirrors.tuna.tsinghua.edu.cn/ubuntu/ jammy-backports main restricted universe multiverse

# deb https://mirrors.tuna.tsinghua.edu.cn/ubuntu/ jammy-security main restricted universe multiverse
# # deb-src https://mirrors.tuna.tsinghua.edu.cn/ubuntu/ jammy-security main restricted universe multiverse

deb http://security.ubuntu.com/ubuntu/ jammy-security main restricted universe multiverse
# deb-src http://security.ubuntu.com/ubuntu/ jammy-security main restricted universe multiverse

# 预发布软件源，不建议启用
# deb https://mirrors.tuna.tsinghua.edu.cn/ubuntu/ jammy-proposed main restricted universe multiverse
# # deb-src https://mirrors.tuna.tsinghua.edu.cn/ubuntu/ jammy-proposed main restricted universe multiverse
EOF

sudo apt-get update
sudo apt-get upgrade













sudo apt-get install -y apt-transport-https ca-certificates curl

## 国内的源不需要公钥
#curl -fsSL https://dl.k8s.io/apt/doc/apt-key.gpg | sudo gpg --dearmor -o /etc/apt/keyrings/kubernetes-archive-keyring.gpg

##
# https://developer.aliyun.com/mirror/kubernetes?spm=a2c6h.13651102.0.0.7a341b11wmA6Mg
apt-get update && apt-get install -y apt-transport-https

curl https://mirrors.aliyun.com/kubernetes/apt/doc/apt-key.gpg | apt-key add -

cat <<EOF >/etc/apt/sources.list.d/kubernetes.list
deb https://mirrors.aliyun.com/kubernetes/apt/ kubernetes-xenial main
EOF

apt-get update

apt-get install -y kubelet kubeadm kubectl


# 在 Master 节点下执行
systemctl enable kubelet

kubeadm init \
      --apiserver-advertise-address=192.168.31.6 \
      --image-repository registry.aliyuncs.com/google_containers \
      --kubernetes-version v1.23.6 \
      --service-cidr=10.96.0.0/12 \
      --pod-network-cidr=10.244.0.0/16

# 安装成功后，复制如下配置并执行
mkdir -p $HOME/.kube
sudo cp -i /etc/kubernetes/admin.conf $HOME/.kube/config
sudo chown $(id -u):$(id -g) $HOME/.kube/config
kubectl get nodes

