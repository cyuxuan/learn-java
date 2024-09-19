#
# Copyright ©2023-2023 BeeNest Club. All rights reserved.
#

# 固定IP
network:
    renderer: networkd
    ethernets:
        ens33: # 替换为你的网络接口名称
            dhcp4: false # 关闭 DHCP
            dhcp6: false # 关闭 DHCP
            addresses: [192.168.100.122/24] # 静态 IP 地址和子网掩码
            routes:
              - to: default
                via: 192.168.100.1 # 网关地址
            nameservers:
                addresses: [192.168.100.1] # DNS 服务器地址
                search: []
    version: 2


sudo virsh pool-define-as --name pool_name --type dir --target /path/to/pool_directory
sudo virsh pool-start pool_name
sudo virsh pool-autostart pool_name


# https://cloud.tencent.com/developer/article/2295218

network:
    renderer: networkd
    ethernets:
        ens33:
            dhcp4: false
            dhcp6: false
            addresses: [192.168.43.10/24]
            routes:
              - to: default
                via: 192.168.43.1
            nameservers:
                addresses: [192.168.43.1]
                search: []
    version: 2