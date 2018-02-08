package com.lorne.weixin.test;

import com.lorne.core.framework.utils.config.ConfigHelper;
import com.lorne.weixin.pay.api.AccountPay;
import com.lorne.weixin.pay.api.CreditCardPay;
import com.lorne.weixin.pay.model.WxConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * create by lorne on 2017/9/30
 */

@Configuration
@SpringBootApplication
public class TestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }


    @Bean
    public CreditCardPay creditCardPay(){
        WxConfig config = new WxConfig();

        ConfigHelper helper = new ConfigHelper("weixin.properties");
        config.setAppId(helper.getStringValue("appId"));
        config.setMchId(helper.getStringValue("mchId"));
        config.setAppSecret(helper.getStringValue("appSecret"));
        config.setCertLocalPath(helper.getStringValue("certPath"));
        config.setKey(helper.getStringValue("key"));
        config.setNotifyUrl(helper.getStringValue("notifyUrl"));
        config.setCertPassword(helper.getStringValue("certPassword"));
        CreditCardPay creditCardPay = new CreditCardPay(config);
        return creditCardPay;
    }


    @Bean
    public AccountPay accountPay(){
        WxConfig config = new WxConfig();

        ConfigHelper helper = new ConfigHelper("weixin.properties");
        config.setAppId(helper.getStringValue("appId"));
        config.setMchId(helper.getStringValue("mchId"));
        config.setAppSecret(helper.getStringValue("appSecret"));
        config.setCertLocalPath(helper.getStringValue("certPath"));
        config.setKey(helper.getStringValue("key"));
        config.setNotifyUrl(helper.getStringValue("notifyUrl"));
        config.setCertPassword(helper.getStringValue("certPassword"));
        AccountPay accountPay = new AccountPay(config);
        return accountPay;
    }

}
