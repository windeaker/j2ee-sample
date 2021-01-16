package rabbit.boot.topic;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author winde
 * @Description TODO
 * @Date 2020/12/4
 */
@SpringBootApplication
public class TopicRabbitBoot {
    public static void main(String[] args) {
        SpringApplication.run(TopicRabbitBoot.class,args);
    }

    public final static String topicExchangeName="boot_topic_exchange";
    public final static String topicQueueName1="topic.demo.queue1";
    public final static String topicQueueName2="topic.demo.queue2";


    @Bean
    TopicExchange topicExchange(){
       return new TopicExchange(topicExchangeName);
    }

    @Bean
    Queue topicQueue1(){
        return new Queue(topicQueueName1);
    }
    @Bean
    Queue topicQueue2(){
        return new Queue(topicQueueName2);
    }

    @Bean
    Binding bindQueue1(Queue topicQueue1,TopicExchange topicExchange){
        return BindingBuilder.bind(topicQueue1).to(topicExchange).with("topic.demo.queue1");
    }

    @Bean
    Binding bindQueue2(Queue topicQueue2,TopicExchange topicExchange){
        return BindingBuilder.bind(topicQueue2).to(topicExchange).with("topic.demo.#");
    }

    @RabbitHandler
    public void proccessMSG(String msg){
        System.out.println("msg received : "+msg);
    }

}
