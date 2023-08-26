/*
 * Copyright ©2023-2023 BeeNest Club. All rights reserved.
 */

package club.beenest.blog.service.user;

import club.beenest.blog.entity.user.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * 用户服务
 *
 * @author 陈玉轩
 * @since 1.0
 */
public interface UserService extends UserDetailsService{
    User findUserByUsernameAndPassword(String username, String password);

    User findUserById(Long id);

    boolean changeAccount(User user, String jwt);
}
