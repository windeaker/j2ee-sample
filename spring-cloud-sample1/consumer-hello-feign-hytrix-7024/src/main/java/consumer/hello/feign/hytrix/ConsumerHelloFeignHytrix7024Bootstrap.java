package consumer.hello.feign.hytrix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableFeignClients
public class ConsumerHelloFeignHytrix7024Bootstrap {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerHelloFeignHytrix7024Bootstrap.class,args);
    }

    @Autowired
    ConsumeHelloRemote consumeHelloRemote;


    @GetMapping("/consumeSayHello")
    public String consumeSayHello(@RequestParam("name") String param){
        return consumeHelloRemote.consumeHello(param);
    }


}
