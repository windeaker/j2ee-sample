package spring.hello.world.consumer;

import hello.world.common.api.service.OrderService;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.hello.world.consumer.service.impl.OrderServiceImpl;

import java.io.IOException;

public class ConsumerBootstrap {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("consumer-beans.xml");
        context.start();
        OrderService orderService=(OrderService) context.getBean(OrderServiceImpl.class);
        orderService.initOrder("1");
        System.out.println("结束");
        System.in.read();
    }
}
