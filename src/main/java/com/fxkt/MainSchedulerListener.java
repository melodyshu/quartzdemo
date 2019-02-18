package com.fxkt;

import com.fxkt.listener.MySchedulerListener;
import com.fxkt.listener.MyTriggerListener;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.KeyMatcher;

public class MainSchedulerListener {
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
        scheduler.getListenerManager().addSchedulerListener(new MySchedulerListener());
        scheduler.start();
    }
}
