package com.fxkt;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HelloJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        Date dt=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dtString=sdf.format(dt);
        System.out.println("正在执行任务,时间:"+dtString);
        //获取jobDetail内容
        JobKey jobKey= jobExecutionContext.getJobDetail().getKey();
        System.out.println(jobKey.getName()+"--"+jobKey.getGroup());
        System.out.println(jobExecutionContext.getJobDetail().getJobClass().getName());
        System.out.println(jobExecutionContext.getJobDetail().getJobClass().getSimpleName());
        //获取trigger内容

    }
}
