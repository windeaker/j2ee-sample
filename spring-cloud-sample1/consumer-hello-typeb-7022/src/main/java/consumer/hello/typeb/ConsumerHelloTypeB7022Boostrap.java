package consumer.hello.typeb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class ConsumerHelloTypeB7022Boostrap {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerHelloTypeB7022Boostrap.class,args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/consumeSayHello")
    public String consumeSayHello(@RequestParam("name") String param){
        String url="http://eureka-producer-hello/sayHello?name="+param;
        return restTemplate.getForObject(url,String.class);
    }
}
