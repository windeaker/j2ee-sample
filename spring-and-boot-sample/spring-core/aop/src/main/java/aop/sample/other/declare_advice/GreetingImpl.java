package aop.sample.other.declare_advice;

import org.springframework.stereotype.Component;

@Component
public class GreetingImpl implements Greeting {
    public void sayHello(String name) {
        System.out.println("Hello："+name);
    }
}
