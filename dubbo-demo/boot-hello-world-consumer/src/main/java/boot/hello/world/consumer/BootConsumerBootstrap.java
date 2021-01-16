package boot.hello.world.consumer;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class BootConsumerBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(BootConsumerBootstrap.class,args);
    }
}
