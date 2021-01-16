package spring.application.initializer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired
    ConfigurableApplicationContext context;

    public void printTest(){
       context.publishEvent("");
    }
}
