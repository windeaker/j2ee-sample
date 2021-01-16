package cloud.privider.payment8004;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/9/3
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudProviderPayment8004 {
    public static void main(String[] args) {
        SpringApplication.run(CloudProviderPayment8004.class,args);
    }
}
