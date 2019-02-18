package com.fxkt;

import com.fxkt.listener.MyJobListener;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.EverythingMatcher;
import org.quartz.impl.matchers.KeyMatcher;

public class MainJobListener {
    public static void main(String[] args) throws Exception {
        Scheduler scheduler= StdSchedulerFactory.getDefaultScheduler();
        JobDetail jobDetail= JobBuilder.newJob(HelloJobListener.class)
                .withIdentity("job1","group1")
                .build();
        //定义触发器，马上执行，然后每5秒执行一次
        Trigger trigger= TriggerBuilder.newTrigger()
                .withIdentity("trigger1","group1")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(5))
                .usingJobData("message","触发器数据")
                .build();
        scheduler.scheduleJob(jobDetail,trigger);
        //全局job listener
        //scheduler.getListenerManager().addJobListener(new MyJobListener(), EverythingMatcher.allJobs());
        //局部job listener
        scheduler.getListenerManager().addJobListener(new MyJobListener(), KeyMatcher.keyEquals(JobKey.jobKey("job2","group1")));
        scheduler.start();
    }
}
