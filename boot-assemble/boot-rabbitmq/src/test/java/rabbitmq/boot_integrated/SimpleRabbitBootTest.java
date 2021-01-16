package rabbitmq.boot_integrated;

import org.springframework.amqp.core.Message;
import org.springframework.messaging.support.MessageBuilder;
import rabbit.boot.simple.SimpleRabbitBoot;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import rabbit.pojo.User;

import java.util.Date;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/8/4
 */
@SpringBootTest(classes = SimpleRabbitBoot.class)
@RunWith(SpringRunner.class)
public class SimpleRabbitBootTest {

    @Autowired
    AmqpTemplate amqpTemplate;

    @Test
    public void produceOneStringMsg(){
        String context = "produceOneMsg :" + new Date();
        System.out.println("produce : " + context);
        amqpTemplate.convertAndSend("hello_queue", context);
    }

    @Test
    public void produceOneComplexMsg(){
        amqpTemplate.convertAndSend("hello_queue", User.builder().userName("windeaker").id(1).build());
    }

    @Test
    public void produceManyStringMsg(){
        for(int i=0;i<=1000;i++){
            String context = "produceOneMsg: "+i +" datetime:"+ new Date();
            amqpTemplate.convertAndSend("hello_queue", context);
        }
    }
}
