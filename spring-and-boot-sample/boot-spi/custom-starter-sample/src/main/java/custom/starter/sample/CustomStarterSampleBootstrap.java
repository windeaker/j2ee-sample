package custom.starter.sample;

import custom.starter.CustomStarter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/8/11
 */
@SpringBootApplication
@RestController
public class CustomStarterSampleBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(CustomStarterSampleBootstrap.class,args);
    }
    @Autowired
    CustomStarter customStarter;

    @GetMapping("/getCustomConfig")
    public String getCustomConfig(){
        return customStarter.toString();
    }
}
