package rabbitmq.work_model.topic;

import rabbit.simple.ConnectionUtil;
import com.rabbitmq.client.*;

import java.io.IOException;

public class TopicReceiver1 {
    private final static String exchangeName="test_topic_exchange";
    public static void main(String[] args) throws Exception {
        Connection connection= ConnectionUtil.getConnection();
        Channel channel=connection.createChannel();
        channel.exchangeDeclare(exchangeName,"topic");
        String queueName=channel.queueDeclare().getQueue();
        String routingKey="#.error";
        channel.queueBind(queueName,exchangeName,routingKey);
        Consumer consumer=new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg=new String(body,"UTF-8");
                System.out.println("topic receiver1 msg:"+msg);
            }
        };
        channel.basicConsume(queueName,true,consumer);
    }
}
