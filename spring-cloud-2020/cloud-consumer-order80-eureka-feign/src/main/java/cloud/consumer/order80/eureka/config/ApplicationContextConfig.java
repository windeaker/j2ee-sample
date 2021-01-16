package cloud.consumer.order80.eureka.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/10/15
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }

}
