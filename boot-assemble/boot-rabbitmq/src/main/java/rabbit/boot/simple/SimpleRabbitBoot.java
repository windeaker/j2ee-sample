package rabbit.boot.simple;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author windeaker
 * @Description project boot-rabbit bootstrap class
 * @Date 20/8/4
 */
@SpringBootApplication
public class SimpleRabbitBoot {

    @Bean
    public Queue queue(){
        return new Queue("hello_queue");
    }

    public static void main(String[] args) {
        SpringApplication.run(SimpleRabbitBoot.class,args);
    }
}
