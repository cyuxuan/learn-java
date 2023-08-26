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