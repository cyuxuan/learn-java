/*
 * Copyright ©2023-2023 BeeNest Club. Some rights reserved.
 */

package club.beenest.blog.service.user.impl;

import club.beenest.blog.dao.user.UserMapper;
import club.beenest.blog.entity.User;
import club.beenest.blog.service.user.UserService;
import club.beenest.blog.support.exception.NotFoundException;
import club.beenest.blog.support.util.HashUtils;
import club.beenest.blog.support.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * 用户业务层接口实现类
 *
 * @author 陈玉轩
 * @since 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        return user;
    }

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        User user = userMapper.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        if (!HashUtils.matchBC(password, user.getPassword())) {
            throw new UsernameNotFoundException("密码错误");
        }
        return user;
    }

    @Override
    public User findUserById(Long id) {
        User user = userMapper.findById(id);
        if (user == null) {
            throw new NotFoundException("用户不存在");
        }
        return user;
    }

    @Override
    public boolean changeAccount(User user, String jwt) {
        String username = JwtUtils.getTokenBody(jwt).getSubject();
        user.setPassword(HashUtils.getBC(user.getPassword()));
        if (userMapper.updateUserByUsername(username, user) != 1) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return false;
        }
        return true;
    }
}
