package rabbitmq.work_model;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class ConnectionUtil {
    public static Connection getConnection() throws Exception {
        //定义连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //设置服务地址
        factory.setHost("192.168.199.120");
        //端口
        factory.setPort(5672);
        //设置账号信息，用户名、密码、vhost
        factory.setVirtualHost("/");
        factory.setUsername("windeaker");
        factory.setPassword("windeaker@0917");
        // 通过工程获取连接
        Connection connection = factory.newConnection();
        return connection;
    }
}
