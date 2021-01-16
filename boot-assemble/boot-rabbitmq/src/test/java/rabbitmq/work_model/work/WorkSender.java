package rabbitmq.work_model.work;

import rabbit.simple.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class WorkSender {
    private final static String queueName="work_queue";
    public static void main(String[] args) throws Exception {
        Connection connection=ConnectionUtil.getConnection();
        Channel channel=connection.createChannel();
        channel.queueDeclare(queueName,false,false,false,null);
        channel.basicQos(1);
        String baseMsg="WorkMsg:";
        for(int i=0;i<100;i++){
            String temp=baseMsg+i;
            Thread.sleep(10);
            channel.basicPublish("",queueName,null,temp.getBytes());
        }
        channel.close();
        connection.close();

    }
}
