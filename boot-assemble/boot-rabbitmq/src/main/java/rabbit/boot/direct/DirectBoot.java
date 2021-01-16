package rabbit.boot.direct;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author winde
 * @Description TODO
 * @Date 2020/12/5
 */
@SpringBootApplication
public class DirectBoot {

    public static void main(String[] args) {
        SpringApplication.run(DirectBoot.class,args);
    }

    public final static String directExchangeName="direct_exchange_demo";
    public final static String directExchangeQueue1="direct_exchange_queue1";
    public final static String directExchangeQueue2="direct_exchange_queue2";
    public final static String directExchangeQueue1BindKey="direct_exchange_queue1_bind";
    public final static String directExchangeQueue2BindKey="direct_exchange_queue2_bind";

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange(directExchangeName);
    }
    @Bean
    public Queue directExchangeQueue1(){
        return new Queue(directExchangeQueue1,true,false,false,null);
    }

    @Bean
    public Queue directExchangeQueue2(){
        return new Queue(directExchangeQueue2,true,false,false,null);
    }

    @Bean
    public Binding directExchangeQueue1Bind(DirectExchange directExchange,Queue directExchangeQueue1){
       return  BindingBuilder.bind(directExchangeQueue1).to(directExchange).with(directExchangeQueue1BindKey);
    }

    @Bean
    public Binding directExchangeQueue2Bind(DirectExchange directExchange,Queue directExchangeQueue2){
        return  BindingBuilder.bind(directExchangeQueue2).to(directExchange).with(directExchangeQueue2BindKey);
    }

}
