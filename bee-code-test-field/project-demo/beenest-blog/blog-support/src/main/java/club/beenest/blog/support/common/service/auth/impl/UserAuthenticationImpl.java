/*
 * Copyright ©2023-2023 BeeNest Club. Some rights reserved.
 */

package club.beenest.blog.support.common.service.auth.impl;


import club.beenest.blog.entity.user.User;
import club.beenest.blog.support.common.dao.auth.UserAuthenticationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 用户业务层接口实现类
 *
 * @author 陈玉轩
 * @since 1.0
 */
@Service
public class UserAuthenticationImpl implements UserDetailsService {
    @Autowired
    private UserAuthenticationMapper userAuthenticationMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userAuthenticationMapper.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        return user;
    }
}
