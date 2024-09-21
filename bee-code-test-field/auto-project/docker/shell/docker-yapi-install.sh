#! /bin/bash

mkdir /data/docker/mongodb/ -p

docker network create yapi

docker pull mongo:7.0.3

docker run -dit --name mongodb --restart always \
  --net=yapi -p 27017:27017 -v /data/docker/mongo:/data/db \
  -e MONGO_INITDB_DATABASE=yapi \
  -e MONGO_INITDB_ROOT_USERNAME=beenest \
  -e MONGO_INITDB_ROOT_PASSWORD=Beenest@666??? \
  mongo:7.0.3

#进入mongo客户端
docker exec -it mongodb mongosh admin

#初始化数据库,依次执行下面的命令
db.auth("beenest", "Beenest@666???")
#创建yapi数据库
use yapi;
# 创建给yapi使用的账号和密码，授予可操作的权限
db.createUser({user: 'beenest', pwd: 'Beenest@666???', roles: [{ role: "dbAdmin", db: "yapi" },{ role: "readWrite", db: "yapi" }]});

# 退出mongo客户端
exit


# 进入容器
docker exec -it mongodb bash

#更新源
apt-get update

# 安装 vim
apt-get install vim -y

# 修改 mongo 配置文件
# 将其中的 bindIp: 127.0.0.1 注释掉# bindIp: 127.0.0.1
# 或者改成bindIp: 0.0.0.0
# 即可开启远程连接
vim /etc/mongod.conf.orig


# 创建yapi的配置文件config.json
vim /data/docker/yapi/config.json

# 写入以下内容
{
   "port": "3000",
   "adminAccount": "管理员账户",
   "timeout":120000,
   "db": {
     "servername": "mongo",
     "DATABASE": "yapi",
     "port": 27017,
     "user": "数据库用户名称",
     "pass": "数据库用户密码",
     "authSource": ""
   },
   "mail": {
     "enable": true,
     "host": "smtp.163.com",
     "port": 465,
     "from": "*",
     "auth": {
       "user": "",
       "pass": ""
     }
   }
}




# 拉球Yapi镜像
docker pull yapipro/yapi:1.9.5
# 初始化数据库表
docker run -d --rm \
  --name yapi-init \
  --link mongodb:mongo \
  --net=yapi \
  -v /data/docker/yapi/config.json:/yapi/config.json \
   yapipro/yapi:1.9.5 \
  server/install.js

# 启动yapi容器
docker run -d \
   --name yapi \
   --link mongodb:mongo \
   --restart always \
   --net=yapi \
   -p 3000:3000 \
   -v /data/docker/yapi/config.json:/yapi/config.json \
   yapipro/yapi:1.9.5 \
   server/app.js
