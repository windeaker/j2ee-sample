package boot.rabbit;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author windeaker
 * @Description rabbitmq configuration class
 * @Date 20/8/4
 */
@Configuration
public class RabbitConfig {

    @Bean
    public Queue queue(){
        return new Queue("hello_queue");
    }
}
