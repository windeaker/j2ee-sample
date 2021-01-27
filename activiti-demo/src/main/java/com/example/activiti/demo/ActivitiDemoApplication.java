package com.example.activiti.demo;

import org.activiti.spring.SpringProcessEngineConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionManager;

import javax.sql.DataSource;

@SpringBootApplication(exclude = {org.activiti.spring.boot.SecurityAutoConfiguration.class})
public class ActivitiDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActivitiDemoApplication.class, args);
    }


    @Autowired
    PlatformTransactionManager transactionManager;

    @Autowired
    DataSource dataSource;

    @Bean
    public SpringProcessEngineConfiguration processEngineConfiguration(){

        SpringProcessEngineConfiguration bean=new SpringProcessEngineConfiguration();
        bean.setTransactionManager(transactionManager);
        bean.setDataSource(dataSource);
        // 设置字体，防止乱码
        bean.setActivityFontName("宋体");
        bean.setLabelFontName("宋体");
        bean.setAnnotationFontName("宋体");
        return bean;
    }

}
