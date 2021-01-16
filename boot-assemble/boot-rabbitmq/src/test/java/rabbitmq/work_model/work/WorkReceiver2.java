package rabbitmq.work_model.work;

import rabbit.simple.ConnectionUtil;
import com.rabbitmq.client.*;

import java.io.IOException;

public class WorkReceiver2 {
    public static void main(String[] args) throws Exception {
        Connection con= ConnectionUtil.getConnection();
        Channel channel=con.createChannel();
        channel.queueDeclare("work_queue",false,false,false,null);
        channel.basicQos(1);
        Consumer consumer=new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println("Received Message '" + message + "'");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        };
        channel.basicConsume("work_queue",false,consumer);
    }
}
