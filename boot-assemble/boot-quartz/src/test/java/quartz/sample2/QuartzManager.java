package quartz.sample2;

import org.junit.Test;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.SimpleTriggerImpl;

import java.util.Date;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/8/29
 */
public class QuartzManager {

    public static void main(String[] args){
        //通过SchedulerFactory来获取一个调度器
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler;
        try {
            scheduler = schedulerFactory.getScheduler();
            //引进作业程序
            JobDetail jobDetail =
                    JobBuilder.newJob(HelloJob.class).withIdentity("jobDetail-s1", "jobDetailGroup-s1").build();

            long ctime = System.currentTimeMillis();
            Trigger simpleTrigger=TriggerBuilder.newTrigger()
                    .withIdentity("simpleTrigger", "triggerGroup-s1")
                    .startAt(new Date(ctime+10000))
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                            .withIntervalInMilliseconds(1000)
                            .withRepeatCount(10)
                    ).withPriority(10)
                    .build();
            //new一个触发器
//            SimpleTrigger simpleTrigger =(SimpleTrigger) TriggerBuilder.newTrigger().forJob("simpleTrigger", "triggerGroup-s1").build();
//            SimpleTriggerImpl simpleTrigger=new SimpleTriggerImpl("simpleTrigger", "triggerGroup-s1");
//
//            //设置作业启动时间
//
//
//            simpleTrigger.setStartTime(new Date(ctime+10000));
//
//
//            //设置作业执行间隔
//            simpleTrigger.setRepeatInterval(1000);
//
//            //设置作业执行次数
//            simpleTrigger.setRepeatCount(10);
//
//            //设置作业执行优先级默认为5
//            //simpleTrigger.setPriority(10);
//
//
//            //作业和触发器设置到调度器中
            scheduler.scheduleJob(jobDetail, simpleTrigger);

//启动调度器
            scheduler.start();

            scheduler.shutdown(false);
//            Thread.sleep(100000);
        } catch (SchedulerException  e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
