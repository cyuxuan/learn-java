#! /bin/bash

#### 环境准备
## 安装apt源
#sudo add-apt-repository ppa:ubuntu-toolchain-r/test

## 更新apt源
#sudo apt-get update

## 检查gcc版本 gcc版本需要和redis版本对应
# gcc -v
## 配置gcc环境
# sudo update-alternatives --install /usr/bin/gcc gcc /usr/bin/gcc-9 50
### 环境准备结束


## 创建redis文件夹
mkdir -p /usr/local/software/redis

## 获取redis包
touch /usr/local/software/redis/redis-6.2.13.tar.gz
curl https://download.redis.io/releases/redis-6.2.13.tar.gz?_gl=1*1um1goa*_ga*MTMxODQ2NTk0MC4xNjkxMjM4MDA4*_ga_8BKGRQKRPV*MTY5MTIzODAwNy4xLjEuMTY5MTIzODA4Ni40OS4wLjA. -o /usr/local/software/redis/redis-6.2.13.tar.gz

## 解压redis
cd /usr/local/software/redis
tar -zxvf redis-6.2.13.tar.gz

## 进入redis目录
cd redis-6.2.13

## 编译并且安装
sudo make && make install

## 默认的安装路径是在 `/usr/local/bin`目录下

## 将redis加入到启动项中
touch /etc/systemd/system/redis.service
cat>/etc/systemd/system/redis.service<<EOF
[Unit]
Description=redis-server
After=network.target

[Service]
Type=forking
ExecStart=/usr/local/bin/redis-server /usr/local/src/redis-6.2.6/redis.conf
PrivateTmp=true

[Install]
WantedBy=multi-user.target
EOF

## 重新加载系统项
sudo systemctl daemon-reload

## 设置开机自启
systemctl enable redis

## 启动
#systemctl start redis
## 停止
#systemctl stop redis
## 重启
#systemctl restart redis
## 查看状态
#systemctl status redis













































