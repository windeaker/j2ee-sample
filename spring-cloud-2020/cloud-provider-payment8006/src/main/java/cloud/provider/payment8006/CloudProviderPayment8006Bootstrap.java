package cloud.provider.payment8006;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/10/20
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudProviderPayment8006Bootstrap {
    public static void main(String[] args) {
        SpringApplication.run(CloudProviderPayment8006Bootstrap.class,args);
    }
}
