package consumer.hello.typea;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class ConsumerHelloTypeA7021Bootstrap {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerHelloTypeA7021Bootstrap.class,args);
    }

    RestTemplate restTemplate;

    @Autowired
    public void setRestTemplate(){
        this.restTemplate=new RestTemplate();
    }

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @GetMapping("/consumeSayHello")
    public String consumeSayHello(@RequestParam("name") String param){
        ServiceInstance serviceInstance=loadBalancerClient.choose("eureka-producer-hello");
        String url="http://"+
                serviceInstance.getHost()+
                ":"+
                serviceInstance.getPort()+
                "/sayHello?name="+param;
        return restTemplate.getForObject(url,String.class);
    }
}
