#! /bin/bash

# 关闭防火墙
systemctl stop firewalld
systemctl disable firewalld

# 关闭selinux
sed -i 's/enforcing/disabled/' /etc/selinux/config  # 永久
setenforce 0  # 临时

# 关闭swap
swapoff -a  # 临时
sed -ri 's/.*swap.*/#&/' /etc/fstab    # 永久

# 关闭完swap后，一定要重启一下虚拟机！！！
# 根据规划设置主机名


sed -i 's/^BOOTPROTO=dhcp$/BOOTPROTO=static/' /etc/sysconfig/network-scripts/ifcfg-ens33
echo "IPADDR=10.8.0.30" >> /etc/sysconfig/network-scripts/ifcfg-ens33
echo "NETMASK=255.255.255.0" >> /etc/sysconfig/network-scripts/ifcfg-ens33
echo "GATEWAY=10.8.0.1" >> /etc/sysconfig/network-scripts/ifcfg-ens33
echo "DNS1=10.8.0.1" >> /etc/sysconfig/network-scripts/ifcfg-ens33
nmcli c reload


hostnamectl set-hostname local-centos8-k8s-master03



kubeadm init phase upload-certs --experimental-upload-certs



mkdir -p $HOME/.kube
sudo cp -i /etc/kubernetes/admin.conf $HOME/.kube/config
sudo chown $(id -u):$(id -g) $HOME/.kube/config