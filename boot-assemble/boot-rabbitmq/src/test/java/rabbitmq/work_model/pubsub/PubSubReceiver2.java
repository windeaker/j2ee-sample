package rabbitmq.work_model.pubsub;

import rabbit.simple.ConnectionUtil;
import com.rabbitmq.client.*;

import java.io.IOException;

public class PubSubReceiver2 {
    public final static String fanoutQueue="test_fanout_queue";

    public final static String test_fanout_exchange="test_fanout_exchange";
    public static void main(String[] args) throws Exception {
        Connection connection= ConnectionUtil.getConnection();
        Channel channel=connection.createChannel();
        channel.exchangeDeclare(test_fanout_exchange,"fanout");
        channel.queueDeclare(fanoutQueue,false,false,false,null);
        //将随机队列和交换机绑定。fanout模式下路由键无效。
        channel.queueBind(fanoutQueue,test_fanout_exchange,"");//队列名，交换机名，路由键
        Consumer consumer=new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("pubsub receiver2 fanout msg:"+new String(body,"UTF-8"));
                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        };
        channel.basicConsume(fanoutQueue,false,consumer);

    }
}
