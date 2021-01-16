package hello.world.common.api.service;


import hello.world.common.api.bean.UserAddress;

import java.util.List;

public interface UserService {
    public List<UserAddress> getUserAddressesList(String userId);
}
