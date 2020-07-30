package aop.sample.test;

import aop.sample.declare_advice.Greeting;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IntroductionAdviceTest {

    @Test
    public void testIntroductionAdvice(){
        ApplicationContext context=new ClassPathXmlApplicationContext("introduction_advice/beans.xml");
        Greeting greeting=(Greeting) context.getBean("greetingProxy");
        greeting.sayHello("spring");
    }
}
