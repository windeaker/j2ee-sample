package cloud.config.center3344;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/10/29
 */
@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class CloudConfigCenter3344Bootstrap {
    public static void main(String[] args) {
        SpringApplication.run(CloudConfigCenter3344Bootstrap.class,args);
    }
}
