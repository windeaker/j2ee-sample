package boot.rabbit;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/8/4
 */
@Component
public class HelloSender {
    @Autowired
    AmqpTemplate amqpTemplate;

//    public void Se
}
