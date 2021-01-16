package quartz.base;

import org.quartz.*;
import org.quartz.impl.StdScheduler;
import org.quartz.impl.StdSchedulerFactory;
import quartz.sample2.HelloJob;

import static org.quartz.SimpleScheduleBuilder.simpleSchedule;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/8/2
 */
public class QuartzFirstDemo {
    public static void main(String[] args) throws SchedulerException {
        SchedulerFactory schedFact = new StdSchedulerFactory();

        Scheduler sched = schedFact.getScheduler();

        sched.start();

        // define the job and tie it to our HelloJob class
        JobDetail job = JobBuilder.newJob(FirstBaseJob.class).
                withIdentity("myJob", "group1").
                build();

        // Trigger the job to run now, and then every 40 seconds
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("myTrigger", "group1").startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(40)
                        .repeatForever()).build();

        // Tell quartz to schedule the job using our trigger
        sched.scheduleJob(job, trigger);
    }
}
