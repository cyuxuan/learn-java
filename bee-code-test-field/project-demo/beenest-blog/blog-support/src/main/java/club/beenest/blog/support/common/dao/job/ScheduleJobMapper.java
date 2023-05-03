/*
 * Copyright ©2023-2023 BeeNest Club. Some rights reserved.
 */

package club.beenest.blog.support.common.dao.job;

import club.beenest.blog.support.common.entity.job.ScheduleJobTask;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 定时任务持久层接口
 *
 * @author 陈玉轩
 * @since　1.0
 */
@Mapper
@Repository
public interface ScheduleJobMapper {
    List<ScheduleJobTask> getJobList();

    ScheduleJobTask getJobById(Long jobId);

    int saveJob(ScheduleJobTask scheduleJob);

    int updateJob(ScheduleJobTask scheduleJob);

    int deleteJobById(Long jobId);

    int updateJobStatusById(@Param("jobId") Long jobId, @Param("status") Boolean status);
}
