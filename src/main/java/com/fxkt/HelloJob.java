package com.fxkt;

import org.quartz.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@PersistJobDataAfterExecution
public class HelloJob implements Job {
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    private Integer count;

    public void setCount(Integer count) {
        this.count = count;
    }

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
        JobDataMap jobDataMap= jobExecutionContext.getJobDetail().getJobDataMap();
        System.out.println("任务数据的参数值:"+jobDataMap.getString("message"));
        //获取trigger内容
        JobDataMap triggerDataMap= jobExecutionContext.getTrigger().getJobDataMap();
        System.out.println("trigger数据的参数值:"+triggerDataMap.getString("message"));

        System.out.println("message的值:"+message);
        ++count;
        System.out.println("count的值:"+count);
        jobExecutionContext.getJobDetail().getJobDataMap().put("count",count);
    }
}
