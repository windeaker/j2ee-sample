package cloud.consumer.order80.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/10/15
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class CloudConsumerOrder80EurekaFeignBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerOrder80EurekaFeignBootstrap.class,args);
    }
}
