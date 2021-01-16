package rabbitmq.boot_integrated;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import rabbit.boot.topic.TopicRabbitBoot;
import rabbit.pojo.User;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/8/4
 */
@SpringBootTest(classes = TopicRabbitBoot.class)
@RunWith(SpringRunner.class)
public class TopicRabbitBootTest {

    @Autowired
    AmqpTemplate amqpTemplate;

    @Test
    public void send(){
        amqpTemplate.convertAndSend(TopicRabbitBoot.topicExchangeName,"topic.demo.queue1", User.builder().id(1).userName("windeaker").build());
    }
}
