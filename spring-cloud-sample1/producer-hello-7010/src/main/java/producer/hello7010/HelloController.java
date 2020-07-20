package producer.hello7010;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class HelloController {

    @GetMapping("/sayHello")
    public String sayHello(@RequestParam(name ="name") String a){
        return "Hello, "+a+" "+ new Date();
    }
}
