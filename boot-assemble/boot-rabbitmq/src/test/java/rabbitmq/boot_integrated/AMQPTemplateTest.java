package rabbitmq.boot_integrated;

import boot.rabbit.RabbitBootstrap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/8/4
 */
@SpringBootTest(classes = RabbitBootstrap.class)
@RunWith(SpringRunner.class)
public class AMQPTemplateTest {

    @Autowired
    AmqpTemplate amqpTemplate;

    @Test
    public void simpleSender(){
        String context = "hello " + new Date();
        System.out.println("Sender : " + context);
        amqpTemplate.convertAndSend("hello_queue", context);
    }

    @Test
    public void oneToManySender(){
        String context ="oneToManySender"+new Date();
        System.out.println("Sender : "+context);
//        amqpTemplate.convertAndSend();
    }
}
