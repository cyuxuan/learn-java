/*
 * Copyright ©2023-2023 BeeNest Club. Some rights reserved.
 */

package club.beenest.blog.dao.user;

import club.beenest.blog.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 用户信息操作
 *
 * @author 陈玉轩
 * @since 1.0
 */
@Mapper
@Repository
public interface UserMapper {
    User findByUsername(String username);

    User findById(Long id);

    int updateUserByUsername(String username, User user);
}
