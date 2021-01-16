package cloud.alibaba.config.nacos.client3377;

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
public class CloudAlibabaConfigNacosClient3377Bootstrap {
    public static void main(String[] args) {
        SpringApplication.run(CloudAlibabaConfigNacosClient3377Bootstrap.class,args);
    }
}
