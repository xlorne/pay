package com.hou.aliPay.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * create by lorne on 2017/9/25
 */
@Configuration
@SpringBootApplication
public class AliPayConfiguration {


    public static void main(String[] args) {
        SpringApplication.run(AliPayConfiguration.class, args);
    }

}
