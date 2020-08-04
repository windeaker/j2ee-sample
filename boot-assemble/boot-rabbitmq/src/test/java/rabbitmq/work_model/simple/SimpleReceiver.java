package rabbitmq.work_model.simple;

import rabbitmq.work_model.ConnectionUtil;
import com.rabbitmq.client.*;

import java.io.IOException;

public class SimpleReceiver {
    private final static String  queueName="q_test_01";

    public static void main(String[] args) throws Exception {
        Connection connection= ConnectionUtil.getConnection();
        Channel channel=connection.createChannel();
        // 声明队列【参数说明：参数一：队列名称，参数二：是否持久化；参数三：是否独占模式；参数四：消费者断开连接时是否删除队列；参数五：消息其他参数】
        channel.queueDeclare(queueName,false,false,false,null);
        Consumer consumer=new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println("Received Message '" + message + "'");
            }
        };
        //持续消费消息【队列名，是否自动确认，消费者对象】
        channel.basicConsume(queueName,true,consumer);

        //只接受单条消息
//        // 参数【队列名，是否自动确认】
//        GetResponse resp = channel.basicGet(queueName, false);
//        String message = new String(resp.getBody(), "UTF-8");
//        channel.basicAck(resp.getEnvelope().getDeliveryTag(), false);// 手动确认消息【参数说明：参数一：该消息的index；参数二：是否批量应答，true批量确认小于当前id的消息】
//        //消息拒绝
//        //channel.basicReject(resp.getEnvelope().getDeliveryTag(), true);
    }
}
