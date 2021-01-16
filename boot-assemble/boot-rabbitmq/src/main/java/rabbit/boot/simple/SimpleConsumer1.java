package rabbit.boot.simple;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/8/4
 */
@Component
@RabbitListener(queues = "hello_queue")
public class SimpleConsumer1 {
    @RabbitHandler
    public void proccessMSG(String msg){
        System.out.println(this.getClass().getCanonicalName()+" msg received : "+msg);
    }

}
