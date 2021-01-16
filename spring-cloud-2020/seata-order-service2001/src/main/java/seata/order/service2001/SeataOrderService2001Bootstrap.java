package seata.order.service2001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SeataOrderService2001Bootstrap {

    public static void main(String[] args) {
        SpringApplication.run(SeataOrderService2001Bootstrap.class,args);
    }
}
