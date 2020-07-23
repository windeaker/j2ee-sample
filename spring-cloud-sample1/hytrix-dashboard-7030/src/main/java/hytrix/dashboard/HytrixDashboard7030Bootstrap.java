package hytrix.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableCircuitBreaker //或@EnableHystrix 开启断路器功能
@EnableHystrixDashboard
@SpringBootApplication
public class HytrixDashboard7030Bootstrap {
    public static void main(String[] args) {
        SpringApplication.run(HytrixDashboard7030Bootstrap.class, args);
    }
}
