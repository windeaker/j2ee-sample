package websocket.sample2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/8/8
 */
@Controller
@ServerEndpoint("/ws2")
public class WebsocketServerEndpoint2 {

    private Logger logger= LoggerFactory.getLogger(getClass());

    public void onOpen(Session session, EndpointConfig config){
        logger.info("[onOpen][session({}) 接入]", session);

    }

    @OnMessage
    public void onMessage(Session session, String message) {
        logger.info("[onOpen][session({}) 接收到一条ws2消息({})]", session, message); // 生产环境下，请设置成 debug 级别
    }

    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        logger.info("[onClose][session({}) 连接关闭。关闭原因是({})}]", session, closeReason);
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        logger.info("[onClose][session({}) 发生异常]", session, throwable);
    }

}
