package autoconfiguration.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWorldConfiguration {

    @Bean(name = "helloWorld")
    public String HelloWorld(){
        return "Hello World Bean";
    }

    @Bean
    public String HelloWorldSelector(){
        return "Hello World Selector Bean";
    }
}
