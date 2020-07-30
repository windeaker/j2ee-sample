package aop.sample.test;

import aop.sample.declare_advice.Greeting;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DeclareAdviceTest {

    @Test
    public void testDeclareAdvice(){
        ApplicationContext context=new ClassPathXmlApplicationContext("declare_advice/beans.xml");
        Greeting greeting=(Greeting) context.getBean("greetingProxy");
        greeting.sayHello("spring");
    }
}
