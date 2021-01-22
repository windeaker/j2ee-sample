package com.windeaker.my_spring.service.impl;

import com.windeaker.my_spring.annotation.MyService;
import com.windeaker.my_spring.service.DemoService;

/**
 * @author xiong qiang
 * @Description TODO
 * @Date 2021/1/22
 */
@MyService
public class DemoServiceImpl implements DemoService {
    public String get(String name) {
        return "this is a"+name;
    }
}
