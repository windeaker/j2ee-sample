package consumer.hello.feign.hytrix;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class HelloRemoteHytrix implements ConsumeHelloRemote{
    @Override
    public String consumeHello(@RequestParam("name") String name) {
        return "remote producer has been over,start fallback";
    }
}
