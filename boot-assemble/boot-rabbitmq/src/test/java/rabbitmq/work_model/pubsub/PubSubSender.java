package rabbitmq.work_model.pubsub;

import rabbitmq.work_model.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class PubSubSender {
    private final static String test_fanout_exchange="test_fanout_exchange";
    public static void main(String[] args) throws Exception {
        Connection connection= ConnectionUtil.getConnection();
        Channel channel=connection.createChannel();
        // 参数1是交换机名称，参数二是交换机类型
        channel.exchangeDeclare(test_fanout_exchange,"fanout");
        String msg="fanout_exchange_msg";
        channel.basicPublish(test_fanout_exchange,"",null,msg.getBytes());
        channel.close();
        connection.close();
    }
}
