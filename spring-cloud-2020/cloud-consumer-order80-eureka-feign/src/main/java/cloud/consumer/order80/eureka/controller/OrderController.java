package cloud.consumer.order80.eureka.controller;

import cloud.api.common.entities.CommonResult;
import cloud.api.common.entities.Payment;
import cloud.consumer.feign.hystrix.order80.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/10/15
 */
@Slf4j
@RestController
public class OrderController {

    @Autowired
    PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        return paymentFeignService.create(payment);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }

}
