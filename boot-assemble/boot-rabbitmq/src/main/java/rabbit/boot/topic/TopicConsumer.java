package rabbit.boot.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import rabbit.pojo.User;

/**
 * @author winde
 * @Description TODO
 * @Date 2020/12/4
 */
@Component
@RabbitListener()
public class TopicConsumer {
    @RabbitHandler
    public void consumer(User user){
        System.out.println("cosume message:  "+user.toString());
    }

}
