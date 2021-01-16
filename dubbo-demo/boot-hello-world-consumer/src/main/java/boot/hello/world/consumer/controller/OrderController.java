package boot.hello.world.consumer.controller;

import hello.world.common.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;


    @GetMapping("/initOrder/{userId}")
    public String initOrder(@PathVariable("userId")String userId){
        orderService.initOrder(userId);
        return "ok";
    }
}
