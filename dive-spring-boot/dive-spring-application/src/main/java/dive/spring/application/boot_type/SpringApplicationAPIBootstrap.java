package dive.spring.application.boot_type;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringApplicationAPIBootstrap {
    public static void main(String[] args) {
        SpringApplication springApplication=new SpringApplication(SpringApplicationAPIBootstrap.class);
        springApplication.setWebApplicationType(WebApplicationType.NONE);
        ConfigurableApplicationContext context=springApplication.run(args);
    }
}
