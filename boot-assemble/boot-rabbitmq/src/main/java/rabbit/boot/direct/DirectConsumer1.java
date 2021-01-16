package rabbit.boot.direct;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author winde
 * @Description TODO
 * @Date 2020/12/5
 */
@Component
@RabbitListener(queues = {DirectBoot.directExchangeQueue1})
public class DirectConsumer1 {
}
