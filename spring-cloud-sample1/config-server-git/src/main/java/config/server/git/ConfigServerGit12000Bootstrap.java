package config.server.git;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerGit12000Bootstrap {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerGit12000Bootstrap.class,args);
    }
}
