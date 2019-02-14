package com.fxkt;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class Main {
    public static void main(String[] args) throws Exception {
        Scheduler scheduler= StdSchedulerFactory.getDefaultScheduler();
        JobDetail jobDetail= JobBuilder.newJob(HelloJob.class)
                .withIdentity("job1","group1")
                .build();
        System.out.println("job名称:"+jobDetail.getKey().getName());
        System.out.println("job组名称:"+jobDetail.getKey().getGroup());
        System.out.println("任务类:"+jobDetail.getJobClass().getName());
        //定义触发器，马上执行，然后每5秒执行一次
        Trigger trigger= TriggerBuilder.newTrigger()
                .withIdentity("trigger1","group1")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(5))
                .build();
        scheduler.scheduleJob(jobDetail,trigger);
        scheduler.start();
    }
}
