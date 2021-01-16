package rabbitmq.work_model.topic;

import rabbit.simple.ConnectionUtil;
import com.rabbitmq.client.*;

import java.io.IOException;

public class TopicReceiver2 {
    private final static String exchangeName="test_topic_exchange";
    public static void main(String[] args) throws Exception {
        Connection connection= ConnectionUtil.getConnection();
        Channel channel=connection.createChannel();
        channel.exchangeDeclare(exchangeName,"topic");
        String queueName="test_topic_exchange_queue";
        channel.queueDeclare(queueName,false,false,true,null);
        String routingKey="#.error";
        channel.basicQos(1);
        channel.queueBind(queueName,exchangeName,routingKey);
        Consumer consumer=new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg=new String(body,"UTF-8");
                System.out.println("topic receiver2 msg:"+msg);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                channel.basicAck(envelope.getDeliveryTag(),false);

            }
        };
        channel.basicConsume(queueName,false,consumer);
    }
}
