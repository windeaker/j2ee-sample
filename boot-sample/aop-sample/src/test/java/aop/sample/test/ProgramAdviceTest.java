package aop.sample.test;

import aop.sample.program_advice.Greeting;
import aop.sample.program_advice.GreetingBeforeAndAfterAdvice;
import aop.sample.program_advice.GreetingImpl;
import aop.sample.program_advice.around_advice.GreetingAroundAdvice;
import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;

public class ProgramAdviceTest {
    @Test
    public void testBeforeAndAfter(){
        ProxyFactory proxyFactory=new ProxyFactory();
        proxyFactory.setTarget(new GreetingImpl());
        proxyFactory.addAdvice(new GreetingBeforeAndAfterAdvice());
        Greeting greeting=(Greeting)proxyFactory.getProxy();
        greeting.sayHello("windeaker");
    }

    @Test
    public void testAroundAdvice(){
        ProxyFactory proxyFactory=new ProxyFactory();
        proxyFactory.setTarget(new GreetingImpl());
        proxyFactory.addAdvice(new GreetingAroundAdvice());
        Greeting greeting=(Greeting)proxyFactory.getProxy();
        greeting.sayHello("nansy");
    }
}
