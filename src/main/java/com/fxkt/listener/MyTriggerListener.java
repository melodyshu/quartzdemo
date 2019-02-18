package com.fxkt.listener;

import org.quartz.*;

public class MyTriggerListener implements TriggerListener {

    @Override
    public String getName() {
        String name=this.getClass().getName();
        System.out.println("trigger名称:"+name);
        return name;
    }

    @Override
    public void triggerFired(Trigger trigger, JobExecutionContext context) {
        System.out.println("triggerFired");
    }

    @Override
    public boolean vetoJobExecution(Trigger trigger, JobExecutionContext context) {
        return false;
    }

    @Override
    public void triggerMisfired(Trigger trigger) {
        System.out.println("triggerMisfired");
    }

    @Override
    public void triggerComplete(Trigger trigger, JobExecutionContext context, Trigger.CompletedExecutionInstruction triggerInstructionCode) {
        System.out.println("triggerComplete");
    }
}
