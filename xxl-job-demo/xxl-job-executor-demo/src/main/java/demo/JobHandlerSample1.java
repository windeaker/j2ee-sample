package demo;

import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.executor.XxlJobExecutor;
import com.xxl.job.core.handler.IJobHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * @author winde
 * @Description BEAN模式（类形式）
 * @Date 2021/2/13
 */
public class JobHandlerSample1 extends IJobHandler {
    Logger logger= LoggerFactory.getLogger(JobHandlerSample1.class);
    @Override
    public void execute() throws Exception {
        logger.info("BEAN模式（类形式）:XXL-JOB, Hello World.");
        XxlJobHelper.log("BEAN模式（类形式）:XXL-JOB, Hello World.");
        for (int i = 0; i < 5; i++) {
            XxlJobHelper.log("beat at:" + i);
            TimeUnit.SECONDS.sleep(2);
        }
    }
}
