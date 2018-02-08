package com.lorne.weixin.test.service;

import java.util.Map;

/**
 * create by lorne on 2017/9/25
 */
public interface TestService {



    Map<String,Object> microPay(String authCode ,String outTradeNo );


    Map<String, Object> queryOrder(String outTradeNo) ;


    boolean refundOrder(String outTradeNo,int money);

    boolean closeOrder(String outTradeNo);


    Map<String,Object> transfers( String openid, int amount);

    Map<String,Object> accountPay(int amount, String openId);

    Map<String,Object> getOpenId(String code);
}
