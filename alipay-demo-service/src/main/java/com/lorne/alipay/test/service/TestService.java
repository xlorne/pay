package com.lorne.alipay.test.service;

/**
 * Created by houcunlu on 2017/10/19.
 */
public interface TestService {


    /**
     * 当面付 ： 条码支付
     * @param
     * @return
     */
    String barcodePay(String orderNo,String authToken, String payCode, String storeId);



    String queryOrder(String orderNo,String authToken);


    String refundOrder(String orderNo,String authToken,String money);


    String closeOrder(String orderNo,String authToken);

    String refreshToken(String token);

    String queryToken(String token);



}
