package demo;

import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author winde
 * @Description BEAN模式（类形式）
 * @Date 2021/2/13
 */
@Component
public class JobHandlerSample2 {
    Logger logger= LoggerFactory.getLogger(JobHandlerSample2.class);

    @XxlJob("simpleJobHandler")
    public void simpleJobHandler() throws Exception {
        logger.info("BEAN模式（方法形式）:simpleJobHandler");
        XxlJobHelper.log("BEAN模式（方法形式）:simpleJobHandler");
        for (int i = 0; i < 5; i++) {
            XxlJobHelper.log("beat at:" + i);
            TimeUnit.SECONDS.sleep(2);
        }
        // 设置任务超时
//        XxlJobHelper.handleSuccess();
//        XxlJobHelper.handleFail();
    }

    @XxlJob(value = "lifeCircleHandler",init = "init",destroy = "destroy")
    public void lifeCircleHandler() {
        logger.info("BEAN模式（方法形式）:lifeCircleHandler-executing");
    }

    public void init(){
        logger.info("BEAN模式（方法形式）:lifeCircleHandler-init");
    }

    public void destroy(){
        logger.info("BEAN模式（方法形式）:lifeCircleHandler-destroy");
    }

    @XxlJob("handlerWithParam")
    public void handlerWithParam(){
        String param = XxlJobHelper.getJobParam();
        logger.info("BEAN模式（方法形式）:handlerWithParam:{}",param);
    }





}
