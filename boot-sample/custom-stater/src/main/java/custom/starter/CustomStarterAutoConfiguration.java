package custom.starter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/8/11
 */
@Configuration
@ConditionalOnWebApplication
@ConditionalOnClass(CustomStarter.class)
@EnableConfigurationProperties(CustomConfigProperties.class)
public class CustomStarterAutoConfiguration {
    /**
     * 当存在custom.config.enable=true的配置时,这个Student bean才生效
     *
     * @return
     */
    @Bean
    @ConditionalOnProperty(prefix = "custom.config", name = "enable", havingValue = "true")
    public CustomStarter customStarter(CustomConfigProperties customConfigProperties) {
        CustomStarter student = new CustomStarter();
        student.setId(customConfigProperties.getId());
        student.setName(customConfigProperties.getName());
        return student;
    }
}
