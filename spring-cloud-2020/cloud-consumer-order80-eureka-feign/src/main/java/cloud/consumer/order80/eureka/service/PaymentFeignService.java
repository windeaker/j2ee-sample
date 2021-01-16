package cloud.consumer.order80.eureka.service;

import cloud.api.common.entities.CommonResult;
import cloud.api.common.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author winde
 * @Description TODO
 * @Date 2020/12/8
 */
@FeignClient("CLOUD-PAYMENT-SERVICE")
@Component
public interface PaymentFeignService {
    @GetMapping(value = "/payment/get/{id}")
    CommonResult getPaymentById(@PathVariable("id") Long id);

    @GetMapping("/consumer/payment/create")
    CommonResult<Payment> create(@RequestBody Payment payment);

}
