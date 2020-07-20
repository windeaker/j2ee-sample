package eureka.dual7001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaDual7001Bootstrap {
    public static void main(String[] args) {
        SpringApplication.run(EurekaDual7001Bootstrap.class,args);
    }
}