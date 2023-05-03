/*
 * Copyright ©2023-2023 BeeNest Club. Some rights reserved.
 */

package club.beenest.blog.support.common.dao.log;

import club.beenest.blog.support.common.entity.log.VisitLog;
import club.beenest.blog.support.common.entity.log.VisitLogUuidTime;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 访问日志持久层接口
 *
 * @author 陈玉轩
 * @since 1.0
 */
@Mapper
@Repository
public interface VisitLogMapper {
    List<VisitLog> getVisitLogListByUUIDAndDate(@Param("uuid") String uuid
            ,@Param("startDate") String startDate
            ,@Param("startDate") String endDate);

    List<VisitLogUuidTime> getUUIDAndCreateTimeByYesterday();

    int saveVisitLog(VisitLog log);

    int deleteVisitLogById(Long id);

    int countVisitLogByToday();
}
