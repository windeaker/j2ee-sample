package com.windeaker.sbdt.dive.mvc.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloWordRestController {

    @GetMapping("/hello-world")
    public String helloWorld(){
        return "Hello Word!";
    }

    @GetMapping("/hello-params")
    public String helloParams(@RequestParam("params") String params){
        return "hello"+params;
    }
}
