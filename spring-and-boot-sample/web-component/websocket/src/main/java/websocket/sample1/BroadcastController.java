package websocket.sample1;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/8/8
 */
@Controller
public class BroadcastController {

    private AtomicInteger count=new AtomicInteger(0);

    @MessageMapping("/receive")
    @SendTo("/topic/getResponse")
    public ResponseMsg broadcast(RequestMsg msg){
        System.out.println(msg);
        ResponseMsg responseMsg= new ResponseMsg();
        responseMsg.setMsg("BroadcastCtl receive [" + count.incrementAndGet() + "] records");
        return responseMsg;
    }

}
