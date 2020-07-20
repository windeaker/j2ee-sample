package consumer.hello.typec;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("eureka-producer-hello")
public interface ConsumeHelloRemote {

    @GetMapping("/sayHello")
    String consumeHello(@RequestParam("name") String name);
}
