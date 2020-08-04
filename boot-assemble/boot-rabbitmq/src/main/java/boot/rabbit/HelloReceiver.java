package boot.rabbit;

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
public class HelloReceiver {
    @RabbitHandler
    public void proccessMSG(String msg){
        System.out.println("msg received : "+msg);
    }

}
