/*
 * Copyright ©2023-2023 BeeNest Club. All rights reserved.
 */

package club.beenest.blog.support.common.dao.job;

import club.beenest.blog.support.common.entity.log.ScheduleJobLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 定时任务日志持久层接口
 *
 * @author 陈玉轩
 * @since 1.0
 */
@Mapper
@Repository
public interface ScheduleJobLogMapper {
    List<ScheduleJobLog> getJobLogListByDate(@Param("startDate") String startDate, @Param("endDate") String endDate);

    int saveJobLog(ScheduleJobLog jobLog);

    int deleteJobLogByLogId(Long logId);
}
