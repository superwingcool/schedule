package com.wing.schedule.timer;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTest extends TimerTask {

    private String jobName = "";

    public TimerTest(String jobName) {
        super();
        this.jobName = jobName;
    }

    @Override
    public void run() {
        System.out.println("execute " + jobName);
    }

    public static void main(String[] args) {
        Timer timer = new Timer();
        long delay = 1 * 1000;
        long period = 1000;
        timer.schedule(new TimerTest("job1"), delay, period);
        timer.schedule(new TimerTest("job2"), delay, period);
    }
}
