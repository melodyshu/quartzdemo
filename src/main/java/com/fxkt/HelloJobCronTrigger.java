package com.fxkt;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;

import java.text.SimpleDateFormat;
import java.util.Date;

@PersistJobDataAfterExecution
public class HelloJobCronTrigger implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        Date dt=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String dtString=sdf.format(dt);
        System.out.println("正在执行任务,时间:"+dtString);

    }
}
