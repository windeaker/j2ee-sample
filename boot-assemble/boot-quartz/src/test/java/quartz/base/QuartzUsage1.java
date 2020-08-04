package quartz.base;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/8/2
 */
public class QuartzUsage1 {
    public static void main(String[] args) throws SchedulerException {
        SchedulerFactory schedulerFactory=new StdSchedulerFactory();
        Scheduler scheduler=schedulerFactory.getScheduler();
        scheduler.start();
    }
}
