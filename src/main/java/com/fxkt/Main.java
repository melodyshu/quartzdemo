package com.fxkt;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class Main {
    public static void main(String[] args) throws Exception {
        Scheduler scheduler= StdSchedulerFactory.getDefaultScheduler();
        JobDetail jobDetail= JobBuilder.newJob(HelloJob.class)
                .withIdentity("job1","group1")
                .build();
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
