package cloud.consumer.order80.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/10/15
 */
@SpringBootApplication
@EnableEurekaClient
public class CloudConsumerOrder80EurekaRibbonBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerOrder80EurekaRibbonBootstrap.class,args);
    }
}
