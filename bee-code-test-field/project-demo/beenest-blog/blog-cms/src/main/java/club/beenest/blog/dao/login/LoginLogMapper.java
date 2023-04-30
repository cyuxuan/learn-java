/*
 * Copyright ©2023-2023 BeeNest Club. Some rights reserved.
 */

package club.beenest.blog.dao.login;

import club.beenest.blog.entity.LoginLog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


import java.util.List;

/**
 * 登录日志记录
 *
 * @author 陈玉轩
 * @since 1.0
 */
@Mapper
@Repository
public interface LoginLogMapper {
    List<LoginLog> getLoginLogListByDate(String startDate, String endDate);

    int saveLoginLog(LoginLog log);

    int deleteLoginLogById(Long id);
}
