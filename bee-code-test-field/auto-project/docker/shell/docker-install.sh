#! /bin/bash
#
# Copyright ©2023-2023 BeeNest Club. Some rights reserved.
#

## docker安装脚本

## 创建docker安装目录
mkdir -p /usr/local/software/docker
touch docker-23.0.0.tgz
## 获取docker资源
curl https://mirrors.tuna.tsinghua.edu.cn/docker-ce/linux/static/stable/x86_64/docker-23.0.0.tgz -o /usr/local/software/docker/docker-23.0.0.tgz

## 解压docker文件
cd /usr/local/software/docker
tar -xzvf docker-23.0.0.tgz

## 复制解压出来的可执行文件到执行目录里中
cp docker/* /usr/bin/

## 注册docker为service服务
touch /etc/systemd/system/docker.service

## 输入控制信息到service文件中
cat>/etc/systemd/system/docker.service<<EOF
[Unit]
Description=Docker Application Container Engine
Documentation=https://docs.docker.com
After=network-online.target firewalld.service
Wants=network-online.target

[Service]
Type=notify
ExecStart=/usr/bin/dockerd
ExecReload=/bin/kill -s HUP $MAINPID
LimitNOFILE=infinity
LimitNPROC=infinity
LimitCORE=infinity
TimeoutStartSec=0
Delegate=yes
KillMode=process
Restart=on-failure
StartLimitBurst=3
StartLimitInterval=60s

[Install]
WantedBy=multi-user.target
EOF

## 提升docker服务权限
sudo chmod a+x /etc/systemd/system/docker.service

## 启动docker
systemctl start docker

## 设置开机自启
systemctl enable docker.service