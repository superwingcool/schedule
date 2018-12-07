package com.wing.spring.schedule;

import org.quartz.JobExecutionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class MyJob extends QuartzJobBean {

    private static int count = 1;

    @Override
    protected void executeInternal(JobExecutionContext arg0) {
        System.out.println("Myjob开始执行了。。。。" + arg0.getTrigger().getKey().getName());
        ApplicationContext applicationContext = (ApplicationContext) arg0.getJobDetail().getJobDataMap()
                .get("applicationContext");
        System.out.println("获取到的容器是：" + (count++) + "|" + applicationContext);
    }

}
