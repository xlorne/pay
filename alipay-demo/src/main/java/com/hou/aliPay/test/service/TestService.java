package com.hou.aliPay.test.service;

import java.util.Map;

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



}
