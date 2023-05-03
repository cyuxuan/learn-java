/*
 * Copyright ©2023-2023 BeeNest Club. Some rights reserved.
 */

package club.beenest.blog.support.common.service.job;


import club.beenest.blog.support.common.entity.job.ScheduleJobTask;
import club.beenest.blog.support.common.entity.log.ScheduleJobLog;

import java.util.List;

public interface ScheduleJobService {
	List<ScheduleJobTask> getJobList();

	void saveJob(ScheduleJobTask scheduleJob);

	void updateJob(ScheduleJobTask scheduleJob);

	void deleteJobById(Long jobId);

	void runJobById(Long jobId);

	void updateJobStatusById(Long jobId, Boolean status);

	List<ScheduleJobLog> getJobLogListByDate(String startDate, String endDate);

	void saveJobLog(ScheduleJobLog log);

	void deleteJobLogByLogId(Long logId);
}
