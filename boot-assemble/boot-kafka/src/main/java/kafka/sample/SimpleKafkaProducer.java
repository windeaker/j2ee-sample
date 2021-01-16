package kafka.sample;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/8/13
 */
public class SimpleKafkaProducer {

    private final static String brokerList="192.168.199.120:9092";

    private final  static String topic="topic-demo";

    public static void main(String[] args) {
        Properties properties=new Properties();
        properties.put("key.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("bootstrap.servers", brokerList);
        KafkaProducer<String,String> producer=new KafkaProducer<String, String>(properties);
        ProducerRecord<String,String> record=new ProducerRecord<>(topic,"hello,kafka!");
        try{
            producer.send(record);

        }catch (Exception e){
            e.printStackTrace();
        }
        producer.close();
    }


}
