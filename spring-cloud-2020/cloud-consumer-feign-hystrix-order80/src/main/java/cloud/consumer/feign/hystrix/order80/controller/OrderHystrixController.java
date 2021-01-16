package cloud.consumer.feign.hystrix.order80.controller;

import cloud.consumer.feign.hystrix.order80.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author winde
 * @Description TODO
 * @Date 2020/12/9
 */
@Slf4j
@RestController
//@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod",
//        commandProperties = {
//        @HystrixProperty(
//                name = "execution.isolation.thread.timeoutInMilliseconds",
//                value = "50000")
//})
public class OrderHystrixController {
    @Resource
    private PaymentHystrixService paymentHystrixService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        String result = paymentHystrixService.paymentInfo_OK(id);
        log.info("*******result:" + result);
        return result;
    }

//    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod",
//            commandProperties = {@HystrixProperty(
//                    name = "execution.isolation.thread.timeoutInMilliseconds",
//                    value = "150000000")
//            })
//    @HystrixCommand
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        if (id <= 0) {
            throw new RuntimeException("");
        }
        String result = paymentHystrixService.paymentInfo_TimeOut(id);
        log.info("*******result:" + result);
        return result;
    }

    //单个fallback
    public String paymentTimeOutFallbackMethod(Integer id) {
        return "消费者80，支付系统繁忙请10秒钟后再试或者运行出错";
    }

    //下面是全局fallback方法
    public String payment_Global_FallbackMethod() {
        return "Global异常处理信息，请稍后再试,(┬＿┬)";
    }


}
