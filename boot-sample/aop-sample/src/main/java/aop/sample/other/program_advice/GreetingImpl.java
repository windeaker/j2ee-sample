package aop.sample.other.program_advice;

public class GreetingImpl implements Greeting {
    public void sayHello(String name) {
        System.out.println("Hello："+name);
    }
}
