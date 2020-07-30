package aop.sample.program_advice;

public class GreetingImpl implements Greeting {
    public void sayHello(String name) {
        System.out.println("Hello："+name);
    }
}
