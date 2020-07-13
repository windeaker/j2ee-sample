package com.windeaker.sbdt.dive.mvc.rest.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.windeaker.sbdt.dive.mvc.rest"})
public class RestMVCBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(RestMVCBootstrap.class,args);
    }
}
