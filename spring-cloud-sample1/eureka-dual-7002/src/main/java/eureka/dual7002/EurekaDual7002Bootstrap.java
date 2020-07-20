package eureka.dual7002;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaDual7002Bootstrap {
    public static void main(String[] args) {
        SpringApplication.run(EurekaDual7002Bootstrap.class,args);
    }
}