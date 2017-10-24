package com.hou.aliPay.test.service.impl;

import com.hou.aliPay.test.service.TestService;
import com.hou.alipay.config.AliPayConfig;
import com.hou.alipay.utils.AliPayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * Created by houcunlu on 2017/10/19.
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private AliPayConfig aliPayConfig;

    /**
     * 当面付 ： 条码支付
     * @param
     * @return
     */
    @Override
    public String barcodePay(String orderNo , String payCode , String storeId ) {
        String title ="订单标题";
        String totalAmount = "0.01";
        return AliPayUtils.barcodePay(aliPayConfig,orderNo , payCode ,title , storeId , totalAmount);
    }








}
