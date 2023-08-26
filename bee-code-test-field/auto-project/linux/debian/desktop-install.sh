#! /bin/bash

## 参考 https://blog.csdn.net/qq_40829735/article/details/130475741

## 执行更新
sudo apt-get udpate
sudo apt-get upgrade

## 创建账户
sudo adduser demodeom
## demodeom  ALL=(ALL:ALL) NOPASSWD: ALL
sudo visudo

## 设置账号密码
## demodeom  ALL=(ALL:ALL) NOPASSWD: ALL


## 安装Ubuntu默认桌面
sudo apt install ubuntu-desktop

## 重启
sudo reboot

## 使用云服务商提供的VNC登录方式即可访问桌面应用

## 或者使用VNC工具
## 选择 lightdm安装
sudo apt install lightdm

## 安装 x11vnc 服务器
sudo apt install x11vnc

sudo vim /lib/systemd/system/x11vnc.service

cat>/lib/systemd/system/x11vnc.service<<EOF
[Unit]
Description=x11vnc service
After=display-manager.service
network.target syslog.target

[Service]
Type=simple
ExecStart=/usr/bin/x11vnc -forever -display :0 -auth guess -passwd 登陆密码
ExecStop=/usr/bin/killall x11vnc
Restart=on-failure

[Install]
WantedBy=multi-user.target
EOF


## 服务管理
#sudo systemctl daemon-reload
#sudo systemctl enable x11vnc.service
#sudo systemctl start x11vnc.service
#systemctl status x11vnc.service
