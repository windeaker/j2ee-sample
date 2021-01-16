package spring.hello.world.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class ProviderBootstrap {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("provider-beans.xml");
        applicationContext.start();
        System.in.read();
    }
}
