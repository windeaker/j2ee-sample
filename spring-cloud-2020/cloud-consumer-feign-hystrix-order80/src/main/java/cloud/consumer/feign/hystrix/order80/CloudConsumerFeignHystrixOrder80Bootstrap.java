package cloud.consumer.feign.hystrix.order80;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/10/15
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableHystrix
public class CloudConsumerFeignHystrixOrder80Bootstrap {
    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerFeignHystrixOrder80Bootstrap.class,args);
    }
}
