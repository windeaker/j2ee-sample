package com.example.demo.multidatasource.controller;

import com.example.demo.multidatasource.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    TestService testService;

    @RequestMapping("/testPrismMS")
    public Object testPrismMS(){
        return testService.selectPrismMSAllId();
    }

    @RequestMapping("/testPrism")
    public Object testPrism(){
        return testService.selectPrismAllId();
    }

}
