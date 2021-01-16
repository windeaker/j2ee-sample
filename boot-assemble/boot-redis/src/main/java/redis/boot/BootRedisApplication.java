package redis.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BootRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootRedisApplication.class,args);
    }

    @Autowired
    RedisTemplate redisTemplate;

    @RequestMapping("/test")
    public String test(){
        System.out.println(redisTemplate.hasKey("test"));;
        return "ok";
    }
}
