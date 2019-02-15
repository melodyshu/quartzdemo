package com.fxkt;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

public class MainCronTrigger {
    public static void main(String[] args) throws Exception {
        Scheduler scheduler= StdSchedulerFactory.getDefaultScheduler();
        Date startTime=new Date();
        startTime.setTime(startTime.getTime()+3000);
        JobDetail jobDetail= JobBuilder.newJob(HelloJobCronTrigger.class)
                .withIdentity("job1","group1")
                .usingJobData("message","消息数据")
                .build();
        //定义触发器，马上执行，然后每5秒执行一次
        Trigger trigger= TriggerBuilder.newTrigger()
                .withIdentity("trigger1","group1")
                //.startNow()
               //.withSchedule(CronScheduleBuilder.cronSchedule("0 * * * * ?")) //每分钟执行一次
                .withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?")) //每5秒执行一次
                .build();
        scheduler.scheduleJob(jobDetail,trigger);
        scheduler.start();
    }
}
