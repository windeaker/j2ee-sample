package web.mvc.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/8/1
 */
@SpringBootApplication
@RestController
public class WebMvcSampleBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(WebMvcSampleBootstrap.class,args);
    }

    @GetMapping("/getDate")
    public Date getDate(){
        return new Date();
    }
}
