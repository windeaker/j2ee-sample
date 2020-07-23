package consumer.hello.feign.hytrix;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="eureka-producer-hello",fallback = HelloRemoteHytrix.class)
public interface ConsumeHelloRemote {

    @GetMapping("/sayHello")
    String consumeHello(@RequestParam("name") String name);
}
