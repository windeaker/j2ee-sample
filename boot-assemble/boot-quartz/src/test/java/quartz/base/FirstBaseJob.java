package quartz.base;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/8/29
 */
public class FirstBaseJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("准备执行····");
        System.out.println("JobExecutionContext "+context.getClass());
    }
}
