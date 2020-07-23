package zuul.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class ZuulGateway8080Bootstrap {
    public static void main(String[] args) {
        SpringApplication.run(ZuulGateway8080Bootstrap.class,args);
    }
}
