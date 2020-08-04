package quartz.base;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdScheduler;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/8/2
 */
public class QuartzFirstDemo {
    public static void main(String[] args) throws SchedulerException {
        Scheduler scheduler= StdSchedulerFactory.getDefaultScheduler();
        scheduler.start();
        scheduler.shutdown();
    }
}
