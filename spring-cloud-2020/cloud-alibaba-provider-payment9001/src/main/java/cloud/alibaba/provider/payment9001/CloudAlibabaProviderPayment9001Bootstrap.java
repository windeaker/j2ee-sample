package cloud.alibaba.provider.payment9001;

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
public class CloudAlibabaProviderPayment9001Bootstrap {
    public static void main(String[] args) {
        SpringApplication.run(CloudAlibabaProviderPayment9001Bootstrap.class,args);
    }
}
