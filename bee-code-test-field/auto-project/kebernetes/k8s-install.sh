## 测试时可以设置关闭防火墙
systemctl stop firewalld  && systemctl disable firewalld

## 禁用 swap -- 这里主要时考虑性能吗？
swapoff -a && sed -i '/ swap / s/^\(.*\)$/#\1/g' /etc/fstab

## 禁用安全 linux， 方式出现不可预知的问题，完全数据的情况下可以开启更安全
swapoff -a && sed -i '/ swap / s/^\(.*\)$/#\1/g' /etc/fstab

## 将桥接的 IPv4 流量传递到 iptables 的链
cat > /etc/sysctl.d/k8s.conf << EOF
net.bridge.bridge-nf-call-ip6tables = 1
net.bridge.bridge-nf-call-iptables = 1
EOF

## 生效上述配置
sysctl --system