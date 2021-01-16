package cloud.gateway.zuul9526;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author winde
 * @Description TODO
 * @Date 2020/12/10
 */
@SpringBootApplication
@EnableEurekaClient
public class CloudGatewayZuul9526Bootstrap {
    public static void main(String[] args) {
        SpringApplication.run(CloudGatewayZuul9526Bootstrap.class,args);
    }
}
