#! /bin/bash

#
# Copyright ©2023-2023 BeeNest Club. Some rights reserved.
#

## 录取镜像
docker pull ubuntu

## 启动镜像
docker run --name ubuntu -dit -p 7999:7999 ubuntu-base
## 镜像交互
## docker attach 镜像ID 不推荐
## docker exec -it 镜像ID/镜像名称 /bin/bash