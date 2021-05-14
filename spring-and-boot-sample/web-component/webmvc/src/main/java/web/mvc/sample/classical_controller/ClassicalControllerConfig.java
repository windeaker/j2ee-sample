package web.mvc.sample.classical_controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/8/22
 */
@Configuration
public class ClassicalControllerConfig {
    @Bean
    public ClassicalController classicalController(){
        return new ClassicalController();
    }
}
