package cloud.alibaba.consumer.nacos.order83;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Windeaker
 * @Description TODO
 * @Date 2020/11/3
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudAlibabaConsumerNacosOrder83Bootstrap {
    public static void main(String[] args) {
        SpringApplication.run(CloudAlibabaConsumerNacosOrder83Bootstrap.class,args);
    }
}
