package rabbitmq.work_model.topic;

import rabbit.simple.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class TopicSender {
    public static void main(String[] args) throws Exception {
        Connection connection=ConnectionUtil.getConnection();
        Channel channel=connection.createChannel();
        channel.exchangeDeclare("test_topic_exchange","topic");
        String routing_key="com.rabbit.error";
        String msg="test_topic_exchange_msg:";
        for(int i=0;i<100;i++) {
            String temp=msg+i;
            channel.basicPublish("test_topic_exchange", routing_key, null, temp.getBytes());
        }
        channel.close();
        connection.close();
    }
}
