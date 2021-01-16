package cloud.consumer.feign.hystrix.order80.config;

import feign.Logger;
import feign.Request;
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

    @Bean
    Request.Options requestOptions(){
        return new Request.Options(5000,5000);
    }

}
