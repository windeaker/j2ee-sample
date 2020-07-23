package com.windeaker.sbdt.dive.mvc.rest.controller;

import com.windeaker.sbdt.dive.mvc.rest.domain.UserVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

    /**
     * TODO...
     * @param user
     * @return
     */
    @PostMapping("/echo/user")
    public Object echoUser(@RequestBody UserVO user){
        System.out.println(user.toString());
        user.setName("小马哥");
        System.out.println(user.toString());
        return user;
    }
}
