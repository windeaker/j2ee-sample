package websocket.sample3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @author xiong qiang
 * @Description TODO
 * @Date 2021/1/27
 */
@SpringBootApplication
public class WebsocketSample3Bootstrap {
    public static void main(String[] args) {
        SpringApplication.run(WebsocketSample3Bootstrap.class,args);
    }

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
