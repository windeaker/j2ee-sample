package spring.hello.world.consumer.service.impl;

import hello.world.common.api.bean.UserAddress;
import hello.world.common.api.service.UserService;
import hello.world.common.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    UserService userService;

    @Override
    public void initOrder(String userId) {
        System.out.println("userId:"+userId);
        List<UserAddress> userAddresses= userService.getUserAddressesList(userId);
        if (userAddresses!=null){
            for (UserAddress userAddress : userAddresses) {
                System.out.println(userAddress);
            }
        }

    }
}
