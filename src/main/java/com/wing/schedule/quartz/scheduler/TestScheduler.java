package com.wing.schedule.quartz.scheduler;

import com.wing.schedule.quartz.job.MyJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class TestScheduler {

    //创建调度器
    public static Scheduler getScheduler() throws SchedulerException {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        return schedulerFactory.getScheduler();
    }


    public static void schedulerJob() throws SchedulerException {

        JobDetail jobDetail = JobBuilder.newJob(MyJob.class).withIdentity("job1", "group1").build();
        //SimpleTrigger
//        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group3")
//                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(3).repeatForever())
//                .build();
        //CronTrigger
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group3")
                .withSchedule(CronScheduleBuilder.cronSchedule(""))
                .build();

        Scheduler scheduler = getScheduler();
        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();

    }

    public static void main(String[] args) throws SchedulerException {
        TestScheduler testScheduler = new TestScheduler();
        testScheduler.schedulerJob();
    }

} 