package cloud.provider.hystrix.payment8001.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/10/28
 */
@Service
public class PaymentService {

    public String paymentInfo_OK(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "   paymentInfo_OK,id：  " + id + "\t" + "哈哈哈";
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",
            commandProperties = {@HystrixProperty(
                    name = "execution.isolation.thread.timeoutInMilliseconds",
                    value = "2000")//处理超时3s就调用fallback方法
            })
    public String paymentInfo_TimeOut(Integer id) {

        int timeNumber = 3 * 1000;
        if (id <= 0) {
            // 程序运行异常也能被捕获
            throw new RuntimeException("非法id");
        }
        try {
            Thread.sleep(timeNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "线程池："
                + Thread.currentThread().getName()
                + "   paymentInfo_TimeOut,id：  "
                + id
                + "\t"
                + " 耗时(秒)"
                + timeNumber;
    }

    // 服务降级(fallback)处理方法
    public String paymentInfo_TimeOutHandler(Integer id) {
        return "线程池："
                + Thread.currentThread().getName()
                + "   系统繁忙, 请稍候再试  ,id：  "
                + id;
    }

    //服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),  //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),   //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),  //时间范围
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"), //失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("*****id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName() + "\t" + "调用成功,流水号：" + serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id) {
        return "id 不能负数，请稍候再试,(┬＿┬)/~~     id: " + id;
    }


    @HystrixCommand(fallbackMethod = "str_FallbackMethod",
            groupKey = "strGroupCommand",
            commandKey = "",
            threadPoolKey = "",
            commandProperties = {
            // 设置隔离策略，TRHEAD: 线程池， SEMAPHORE 信号池隔离
            @HystrixProperty(name = "execution.isolation,strategy",value = ""),
            @HystrixProperty(name = "",value = ""),
            @HystrixProperty(name = "",value = ""),
            @HystrixProperty(name = "",value = ""),
            @HystrixProperty(name = "",value = ""),
            @HystrixProperty(name = "",value = ""),
            @HystrixProperty(name = "",value = ""),
            @HystrixProperty(name = "",value = ""),
            @HystrixProperty(name = "",value = ""),
            @HystrixProperty(name = "",value = ""),
            @HystrixProperty(name = "",value = ""),
            @HystrixProperty(name = "",value = ""),
            @HystrixProperty(name = "",value = ""),
            @HystrixProperty(name = "",value = ""),
            @HystrixProperty(name = "",value = ""),
            @HystrixProperty(name = "",value = ""),
            @HystrixProperty(name = "",value = ""),
            @HystrixProperty(name = "",value = ""),
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),  //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),   //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),  //时间范围
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"), //失败率达到多少后跳闸
    })
    public String hystrixProperties() {
        return "";
    }

}
