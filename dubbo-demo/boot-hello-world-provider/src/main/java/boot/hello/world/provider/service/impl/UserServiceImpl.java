package boot.hello.world.provider.service.impl;


import hello.world.common.api.bean.UserAddress;
import hello.world.common.api.service.UserService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@com.alibaba.dubbo.config.annotation.Service
@org.springframework.stereotype.Service
public class UserServiceImpl implements UserService {
    @Override
    public List<UserAddress> getUserAddressesList(String userId) {
        return new ArrayList<>(Arrays.asList(
                UserAddress.builder().id(1)
                        .userAddress("地址1")
                        .userId(userId)
                        .consignee("收货人2")
                        .isDefault("否")
                        .phoneNum("127****")
                        .build(),
                UserAddress.builder()
                        .id(2)
                        .userAddress("地址2")
                        .userId(userId)
                        .consignee("收货人2")
                        .isDefault("是")
                        .phoneNum("176*******")
                        .build()));
    }
}
