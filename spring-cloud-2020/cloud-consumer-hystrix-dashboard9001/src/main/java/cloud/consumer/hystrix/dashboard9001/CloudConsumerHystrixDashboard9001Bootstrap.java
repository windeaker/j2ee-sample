package cloud.consumer.hystrix.dashboard9001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/10/28
 */
@SpringBootApplication
@EnableHystrixDashboard
public class CloudConsumerHystrixDashboard9001Bootstrap {
    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerHystrixDashboard9001Bootstrap.class,args);
    }
}
