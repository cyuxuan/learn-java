/*
 * Copyright ©2023-2023 BeeNest Club. All rights reserved.
 */

package club.beenest.blog.support.job.quartz;

import club.beenest.blog.support.common.entity.job.ScheduleJobTask;
import club.beenest.blog.support.common.entity.log.ScheduleJobLog;
import club.beenest.blog.support.common.service.job.ScheduleJobService;
import club.beenest.blog.support.util.SpringContextUtils;
import org.quartz.JobExecutionContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 定时任务执行与结果记录
 *
 * @author 陈玉轩
 * @since　1.0
 */

public class ScheduleJob extends QuartzJobBean {
    private ExecutorService service = Executors.newSingleThreadExecutor();

    @Override
    protected void executeInternal(JobExecutionContext context) {
        ScheduleJobTask scheduleJob = (ScheduleJobTask) context.getMergedJobDataMap().get(ScheduleJobTask.JOB_PARAM_KEY);
        //获取spring bean
        ScheduleJobService scheduleJobService =
                (ScheduleJobService) SpringContextUtils.getBean("scheduleJobServiceImpl");
        //数据库保存任务执行记录
        ScheduleJobLog jobLog = new ScheduleJobLog();
        jobLog.setJobId(scheduleJob.getJobId());
        jobLog.setBeanName(scheduleJob.getBeanName());
        jobLog.setMethodName(scheduleJob.getMethodName());
        jobLog.setParams(scheduleJob.getParams());
        jobLog.setCreateTime(new Date());
        //任务开始时间
        long startTime = System.currentTimeMillis();
        //执行任务
//        log.info("任务准备执行，任务ID：{}", scheduleJob.getJobId());
        try {
            ScheduleRunnable task = new ScheduleRunnable(scheduleJob.getBeanName(), scheduleJob.getMethodName(), scheduleJob.getParams());
            Future<?> future = service.submit(task);
            future.get();
            //任务执行总时长
            long times = System.currentTimeMillis() - startTime;
            jobLog.setTimes((int) times);
            //任务执行结果
            jobLog.setStatus(true);
//            log.info("任务执行成功，任务ID：{}，总共耗时：{} 毫秒", scheduleJob.getJobId(), times);
        } catch (Exception e) {
            //任务执行总时长
            long times = System.currentTimeMillis() - startTime;
            jobLog.setTimes((int) times);
            //任务执行结果
            jobLog.setStatus(false);
            jobLog.setError(e.toString());
//            log.error("任务执行失败，任务ID：{}", scheduleJob.getJobId(), e);
        } finally {
            scheduleJobService.saveJobLog(jobLog);
        }
    }
}
