#! /bin/bash

#
# Copyright ©2023-2023 BeeNest Club. All rights reserved.
#

## 录取镜像
docker pull alpine

## 启动镜像
docker run --name alpine -dit -p 7999:7999 alpine-base

## 重新启动镜像
docker start

## 镜像交互
## docker attach 镜像ID 不推荐
## docker exec -it 镜像ID/镜像名称 /bin/bash