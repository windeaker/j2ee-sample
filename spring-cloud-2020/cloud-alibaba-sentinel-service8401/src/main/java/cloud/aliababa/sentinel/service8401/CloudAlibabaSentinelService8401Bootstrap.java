package cloud.aliababa.sentinel.service8401;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudAlibabaSentinelService8401Bootstrap {
    public static void main(String[] args) {
        SpringApplication.run(CloudAlibabaSentinelService8401Bootstrap.class,args);
    }
}
