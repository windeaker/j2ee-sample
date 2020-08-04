package boot.rabbit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

/**
 * @author windeaker
 * @Description project boot-rabbit bootstrap class
 * @Date 20/8/4
 */
@SpringBootApplication
public class RabbitBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(RabbitBootstrap.class,args);
    }
}
