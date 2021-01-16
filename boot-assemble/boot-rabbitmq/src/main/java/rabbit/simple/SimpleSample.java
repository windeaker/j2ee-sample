package rabbit.simple;

import com.rabbitmq.client.*;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeoutException;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/8/25
 */
public class SimpleSample {

    private final static String DIRECT_EXCHANGE = "direct_exchange";

    private final static String DIRECT_EXCHANGE_QUEUE = "direct_exchange_queue";

    private final  static String DIRECT_EXCHANGE_ROUTING_KEY="direct_exchange_routing_key";



    public Connection getConnection() throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.199.120");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        connectionFactory.setVirtualHost("/");
        Connection connection = connectionFactory.newConnection();
        //        System.out.println(connection.isOpen());
        return connection;
    }

    public Connection getConnectionByUrl() throws NoSuchAlgorithmException, KeyManagementException, URISyntaxException, IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUri("amqp:windeaker:WINDeaker@0917@192.168.199.120:5672//");
        Connection conn = factory.newConnection();
        return conn;
    }

    @Test
    public void exchangeHandle() throws IOException, TimeoutException {
        Channel channel = getConnection().createChannel();
        //创建完交换器后返回


    }

    /**
     * 创建交换器
     *
     * @param channel
     */
    public void createExchange(Channel channel) throws IOException {
        AMQP.Exchange.DeclareOk declareOk = channel.exchangeDeclare(DIRECT_EXCHANGE,
                BuiltinExchangeType.DIRECT,//交换器类型
                true,//是否持久化，设置为true后，交换器会存储到磁盘中，服务器重启不会丢失相关信息
                true,//是否自动删除，
                false,//是否内置交换器
                null);//结构化参数，比如alternate-exchange

        /**
         * 以AMQP中Exchange.Declare命令创建交换器
         * 发起创建交换器后，立即返回，并不知道交换器是否创建成功，此时如果客户端立即使用，则会发生异常。
         * 如果执行该方法后立即使用该交换器，必然发生异常
         */
//        channel.exchangeDeclareNoWait(EX_DIRECT,
//                BuiltinExchangeType.DIRECT,
//                true,
//                false,
//                false,
//                null);

    }

    public void deleteExchange(Channel channel) throws IOException {
        AMQP.Exchange.DeleteOk deleteOk1 = channel.exchangeDelete(DIRECT_EXCHANGE);
        AMQP.Exchange.DeleteOk deleteOk2 = channel.exchangeDelete(DIRECT_EXCHANGE,
                false);//设置为false表示没有在使用的情况吓删除，true：无论如何都要删除
        channel.exchangeDeleteNoWait(DIRECT_EXCHANGE,
                false);//设置为false表示没有在使用的情况吓删除，true：无论如何都要删除
    }


    public void createQueue(Channel channel) throws IOException {

        /**
         * 创建一个匿名，排他，自动删除，非持久化队列
         */
//        AMQP.Queue.DeclareOk declareOk =
//                channel.queueDeclare();

        AMQP.Queue.DeclareOk deleteOk2 = channel.queueDeclare(
                DIRECT_EXCHANGE_QUEUE, //队列名
                true, //是否可持续化
                false,//是否排他
                false, //是否自动删除
                null);//结构化参数如:x-rnessage-ttl

    }

    /**
     * 删除队列
     * @param channel
     * @param queueName
     * @throws IOException
     */
    public void deleteQueue(Channel channel,String queueName) throws IOException {
        channel.queueDelete(queueName);

    }

    /**
     * 将队列与交换机绑定
     * @param channel
     * @param queueName
     * @param exchangeName
     * @throws IOException
     */
    public void bindQueueToExchange(Channel channel,String queueName,String exchangeName,String routingKey) throws IOException {
        channel.queueBind(queueName,exchangeName,routingKey,null);
    }

    public void bindExchangeToExchange(Channel channel,String destination,String source,String routingKey) throws IOException {
        channel.exchangeBind(destination,source,routingKey);
    }

    public void consumeMsgPushMode(Channel channel,String queueName) throws IOException {
        channel.basicConsume(queueName,true,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {

                String message = new String(body, "UTF-8");
                System.out.println("Received Message '" + message + "'");
            }
        });
    }

    public void consumeMsgPullMode(Channel channel,String queueName) throws IOException {
        channel.basicGet(queueName,true);
    }



    @Test
    public void basicPublishMsgSample() throws IOException, TimeoutException {
        Connection connection = getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(DIRECT_EXCHANGE_QUEUE,true,false,false,null);
        channel.exchangeDeclare(DIRECT_EXCHANGE,BuiltinExchangeType.DIRECT,true,false,null);
        channel.queueBind(DIRECT_EXCHANGE_QUEUE, DIRECT_EXCHANGE,DIRECT_EXCHANGE_ROUTING_KEY);
        channel.basicPublish(DIRECT_EXCHANGE,DIRECT_EXCHANGE_ROUTING_KEY,null,"HelloWorld".getBytes());
        connection.close();
    }

    @Test
    public void basicGetMsgSample() throws IOException, TimeoutException {
        Connection connection = getConnection();
        Channel channel = connection.createChannel();
        GetResponse getResponse= channel.basicGet(DIRECT_EXCHANGE_QUEUE,false);
        channel.basicAck(getResponse.getEnvelope().getDeliveryTag(),false);
        System.out.println(new String(getResponse.getBody()));
        connection.close();
    }

    @Test
    public void basicConsumeMsgSample() throws IOException, TimeoutException, InterruptedException {
        Connection connection = getConnection();
        Channel channel = connection.createChannel();
        CountDownLatch countDownLatch=new CountDownLatch(100);
        channel.basicConsume(DIRECT_EXCHANGE_QUEUE,true,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("msg:"+new String(body));
                countDownLatch.countDown();
            }
        });
        //消费一百条消息后才能结束
        countDownLatch.await();
    }




}
