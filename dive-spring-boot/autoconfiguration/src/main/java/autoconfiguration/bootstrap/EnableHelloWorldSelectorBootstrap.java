package autoconfiguration.bootstrap;

import autoconfiguration.annotation.EnableHelloWordSelector;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@EnableHelloWordSelector
public class EnableHelloWorldSelectorBootstrap {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(EnableHelloWorldSelectorBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        // helloWorld Bean 是否存在
        String helloWorld =
                context.getBean("HelloWorldSelector", String.class);

        System.out.println("helloWorldSelector Bean : " + helloWorld);

        // 关闭上下文
        context.close();
    }
}
