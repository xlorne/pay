package com.lorne.weixin.test.service;

import java.util.Map;

/**
 * create by lorne on 2017/9/25
 */
public interface TestService {



    Map<String,Object> microPay(String authCode ,String subMchId,String outTradeNo );


    Map<String, Object> queryOrder(String subMchId,String outTradeNo) ;


    boolean refundOrder(String subMchId,String outTradeNo,int money);

    boolean closeOrder(String subMchId,String outTradeNo);


}
