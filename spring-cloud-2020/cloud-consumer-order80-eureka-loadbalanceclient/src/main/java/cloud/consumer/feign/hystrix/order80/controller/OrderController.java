package cloud.consumer.feign.hystrix.order80.controller;

import cloud.api.common.entities.CommonResult;
import cloud.api.common.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/10/15
 */
@Slf4j
@RestController
public class OrderController {
    public static final String PAYMENT_SERVICE_NAME = "CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        ServiceInstance serviceInstance= loadBalancerClient.choose(PAYMENT_SERVICE_NAME);
        String url="http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/payment/create";
        return restTemplate.postForObject(url , payment, CommonResult.class);  //写操作
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        ServiceInstance serviceInstance= loadBalancerClient.choose(PAYMENT_SERVICE_NAME);
        String url="http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/payment/get/";
        return restTemplate.getForObject(url + id, CommonResult.class);
    }

}
