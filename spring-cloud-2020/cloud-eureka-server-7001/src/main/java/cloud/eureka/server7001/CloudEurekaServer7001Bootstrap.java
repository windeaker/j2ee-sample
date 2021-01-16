package cloud.eureka.server7001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/10/20
 */
@SpringBootApplication
@EnableEurekaServer
public class CloudEurekaServer7001Bootstrap {
    public static void main(String[] args) {
        SpringApplication.run(CloudEurekaServer7001Bootstrap.class,args);
    }
}
