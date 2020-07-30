package test;

import dive.spring.application.initializer.DiveSpringApplicationBootstrap;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = DiveSpringApplicationBootstrap.class)
@RunWith(SpringRunner.class)
public class Test {

    @Autowired
    ConfigurableApplicationContext context;

    @org.junit.Test
    public void doTest(){
        context.publishEvent(new ApplicationEvent("hello") {
        });
    }

}
