package com.hou.aliPay.test.service.impl;

import com.hou.aliPay.test.service.TestService;
import com.hou.alifacepay.pay.AliPay;
import org.springframework.stereotype.Service;



/**
 * Created by houcunlu on 2017/10/19.
 */
@Service
public class TestServiceImpl implements TestService {



    /**
     * 当面付 ： 条码支付
     * @param
     * @return
     */
    @Override
    public String barcodePay(String orderNo , String payCode , String storeId ) {
        String title ="订单标题";
        String totalAmount = "0.01";
        String str =  AliPay.barcodePay(orderNo , payCode ,title , storeId , totalAmount);
        return str;
    }








}
