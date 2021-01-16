package spring.application.boot_type;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class DefaultBootstrap {
    public static void main(String[] args) {
        ConfigurableApplicationContext context= SpringApplication.run(ApplicationConfiguration.class,args);
    }

    @SpringBootApplication
    public static class ApplicationConfiguration{

    }
}
