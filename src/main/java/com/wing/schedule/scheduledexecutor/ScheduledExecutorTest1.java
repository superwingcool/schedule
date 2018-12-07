package com.wing.schedule.scheduledexecutor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorTest1 implements Runnable {
    private String jobName = "";

    public ScheduledExecutorTest1(String jobName) {
        super();
        this.jobName = jobName;
    }

    public void run() {
        System.out.println("execute " + jobName);
    }

    public static void main(String[] args) {

        ScheduledExecutorService service = Executors.newScheduledThreadPool(10);
        long initialDelay = 1;
        long period = 1;

        service.scheduleAtFixedRate(
                new ScheduledExecutorTest1("job1"), initialDelay,
                period, TimeUnit.SECONDS);

        service.scheduleWithFixedDelay(
                new ScheduledExecutorTest1("job2"), initialDelay,
                period, TimeUnit.SECONDS);
    }
}