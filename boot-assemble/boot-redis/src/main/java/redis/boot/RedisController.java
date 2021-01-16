package redis.boot;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author winde
 * @Description TODO
 * @Date 2020/12/6
 */
@RestController
public class RedisController {
    @RequestMapping("/getUser/{id}")
    @Cacheable(value="user-key")
    public User getUser(@PathVariable Integer id) {
        User user=new User(id,"aa@126.com");
        return user;
    }
}
