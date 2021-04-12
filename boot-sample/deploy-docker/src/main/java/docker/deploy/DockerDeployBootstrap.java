package docker.deploy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;
import java.util.Date;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/8/4
 */
@SpringBootApplication
@RestController
public class DockerDeployBootstrap {
    Logger logger = LoggerFactory.getLogger(DockerDeployBootstrap.class);

    public static void main(String[] args) {
        SpringApplication.run(DockerDeployBootstrap.class, args);
    }

    @GetMapping("/test")
    public String testController(@RequestParam String name) {
        String result = "docker deployed:" + name + ",time=" + new Date();
        System.out.println(result);
        logger.info(result);
        return result;
    }
}
