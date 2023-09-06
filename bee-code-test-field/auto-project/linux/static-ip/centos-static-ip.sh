#! /bin/bash

# 修改/etc/sysconfig/network-scripts/ifcfg-{你的网卡名称}
# 我的/etc/sysconfig/network-scripts/ifcfg-{你的网卡名称}

# BOOTPROTO="static"  # 修改为静态

#  ONBOOT="yes"  # 修改为开机启动
#  IPADDR=10.10.0.183  # 静态IP
#  NETMASK=255.255.254.0  # 子网掩码
#  GATEWAY=10.10.0.1  # 网关地址
#  DNS1=114.114.114.114  # DNS地址

#
#  # 在CentOS7上可以用
#  # service network restrat 重启网卡
#  # 不过在CentOS8上，得使用
#  nmcli c reload
#  # 如果不生效则
#  nmcli c up ens33  # ens33为网卡名字

hostnamectl set-hostname local-centos8-k8s-node1

mkdir /etc/sysconfig/network-scripts/ifcfg-ens33
cp  /etc/sysconfig/network-scripts/ifcfg-ens33 /etc/sysconfig/network-scripts/backup/
rm -rf /etc/sysconfig/network-scripts/ifcfg-ens33
touch /etc/sysconfig/network-scripts/ifcfg-ens33

sudo tee /etc/sysconfig/network-scripts/ifcfg-ens33 <<-'EOF'
TYPE=Ethernet
PROXY_METHOD=none
BROWSER_ONLY=no
BOOTPROTO=static
DEFROUTE=yes
IPV4_FAILURE_FATAL=no
IPV6INIT=yes
IPV6_AUTOCONF=yes
IPV6_DEFROUTE=yes
IPV6_FAILURE_FATAL=no
NAME=ens33
UUID=28c1752f-9a7f-44b0-95ae-995e2f2ddb4d
DEVICE=ens33
ONBOOT=yes
IPADDR=10.8.0.11
NETMASK=255.255.255.0
GATEWAY=10.8.0.1
DNS1=10.8.0.1
EOF

nmcli c reload
