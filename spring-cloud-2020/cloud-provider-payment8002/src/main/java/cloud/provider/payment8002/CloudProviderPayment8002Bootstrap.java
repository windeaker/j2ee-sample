package cloud.provider.payment8002;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/9/9
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class CloudProviderPayment8002Bootstrap {
    public static void main(String[] args) {
        SpringApplication.run(CloudProviderPayment8002Bootstrap.class,args);
    }
}
