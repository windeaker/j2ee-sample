package rabbitmq.work_model.simple;

import rabbitmq.work_model.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class SimpleSender {
    private final static String QUEUE_NAME = "q_test_01";

    public static void main(String[] argv) throws Exception {
        // 获取到连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        // 从连接中创建通道
        Channel channel = connection.createChannel();

        // 声明队列【参数说明：参数一：队列名称，参数二：是否持久化；参数三：是否独占模式；参数四：消费者断开连接时是否删除队列；参数五：消息其他参数】
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        // 消息内容
        String message = "Hello World!";
        // 推送内容【参数说明：参数一：交换机名称；参数二：队列名称，参数三：消息的其他属性-路由的headers信息；参数四：消息主体】
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        //关闭通道和连接
        channel.close();
        connection.close();
    }
}
