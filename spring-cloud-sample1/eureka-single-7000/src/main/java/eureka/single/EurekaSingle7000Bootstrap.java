package eureka.single;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaSingle7000Bootstrap{
    public static void main(String[] args) {
        SpringApplication.run(EurekaSingle7000Bootstrap.class,args);
    }
}