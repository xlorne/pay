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
    String barcodePay(String orderNo , String payCode , String storeId);


    String queryOrder(String orderNo);


    String refundOrder(String orderNo,String money);


    String closeOrder(String orderNo);


}
