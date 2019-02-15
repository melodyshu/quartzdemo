package com.fxkt;

import org.quartz.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@PersistJobDataAfterExecution
public class HelloJobTrigger implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        Date dt=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dtString=sdf.format(dt);
        System.out.println("正在执行任务,时间:"+dtString);
        Trigger trigger= jobExecutionContext.getTrigger();
        System.out.println(trigger.getJobKey().getName());
        System.out.println("任务开始时间:"+sdf.format(trigger.getStartTime()));
        System.out.println("任务结束时间:"+sdf.format(trigger.getEndTime()));
    }
}
