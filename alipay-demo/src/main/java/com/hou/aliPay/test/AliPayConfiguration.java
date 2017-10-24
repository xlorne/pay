package com.hou.aliPay.test;

import com.hou.alipay.config.AliPayConfig;
import com.lorne.core.framework.utils.config.ConfigUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
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

    @Bean
    public AliPayConfig aliPayConfig(){
        AliPayConfig aliPayConfig = new AliPayConfig();
        aliPayConfig.setAlipayPublicKey(ConfigUtils.getString("alipay.properties","ALIPAY_PUBLIC_KEY"));
        aliPayConfig.setAppId(ConfigUtils.getString("alipay.properties","APP_ID"));
        aliPayConfig.setAppPrivateKey(ConfigUtils.getString("alipay.properties","APP_PRIVATE_KEY"));
        aliPayConfig.setSignType(ConfigUtils.getString("alipay.properties","SIGN_TYPE"));
        return aliPayConfig;
    }

}
