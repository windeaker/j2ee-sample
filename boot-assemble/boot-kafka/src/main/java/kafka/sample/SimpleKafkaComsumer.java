package kafka.sample;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/8/13
 */
public class SimpleKafkaComsumer {
    private final static String brokerList="192.168.199.120:9092";

    private final  static String topic="topic-demo";

    public static final String groupId = "group.demo";

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put("key.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("bootstrap.servers", brokerList);
        //设置消费组的名称，具体的释义可以参见第3章
        properties.put("group.id", groupId);
        KafkaConsumer<String,String> consumer=new KafkaConsumer<String, String>(properties);
        consumer.subscribe(Collections.singletonList(topic));
        while (true){
            ConsumerRecords<String,String> records=consumer.poll(Duration.ofMillis(1000));
            for (ConsumerRecord record:records){
                System.out.println(record.value());
            }
        }
    }
}
