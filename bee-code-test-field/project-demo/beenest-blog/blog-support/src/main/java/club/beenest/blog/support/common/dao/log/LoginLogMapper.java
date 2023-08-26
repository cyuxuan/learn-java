/*
 * Copyright ©2023-2023 BeeNest Club. All rights reserved.
 */

package club.beenest.blog.support.common.dao.log;

import club.beenest.blog.support.common.entity.log.LoginLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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
    List<LoginLog> getLoginLogListByDate(@Param("startDate") String startDate
            ,@Param("endDate") String endDate);

    int saveLoginLog(LoginLog log);

    int deleteLoginLogById(Long id);
}
