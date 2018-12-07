package com.wing.annotation.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MessageSendService {

    /**
     * 定时任务方法
     */
    @Scheduled(cron = "0/10 * * * * ? ")
    //@Scheduled(fixedRate = 5000)
    public void send(){
        System.out.println("Annotation Testing");

    }
}
