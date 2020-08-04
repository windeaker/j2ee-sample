package rabbitmq.work_model.pubsub;

import rabbitmq.work_model.ConnectionUtil;
import com.rabbitmq.client.*;

import java.io.IOException;

public class PubSubReceiver1 {
    public final static String test_fanout_exchange="test_fanout_exchange";
    public static void main(String[] args) throws Exception {
        Connection connection= ConnectionUtil.getConnection();
        Channel channel=connection.createChannel();
        //创建交换机【交换机名称，交换机类型】
        channel.exchangeDeclare(test_fanout_exchange,"fanout");
        //创建一个随机队列，一旦消费者断开连接，该队列就会被删除。
        String queueName=channel.queueDeclare().getQueue();
        //将随机队列和交换机绑定。fanout模式下路由键无效。
        channel.queueBind(queueName,test_fanout_exchange,"");//队列名，交换机名，路由键
        Consumer consumer=new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("pubsub receiver2 fanout msg:"+new String(body,"UTF-8"));
                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        };
        channel.basicConsume(queueName,false,consumer);

    }
}
