package com.lorne.alipay.test.service.impl;

import com.lorne.alipay.test.service.TestService;
import com.lorne.alipay.config.AliPayConfig;
import com.lorne.alipay.utils.AliPayUtils;
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
        String timeoutExpress = "";
        return AliPayUtils.barcodePay(aliPayConfig,orderNo , payCode ,title , storeId , totalAmount,timeoutExpress);
    }


    @Override
    public String queryOrder(String orderNo) {
        return AliPayUtils.queryOrder(aliPayConfig,orderNo);
    }

    @Override
    public String refundOrder(String orderNo, String money) {
        return AliPayUtils.refundOrder(aliPayConfig,orderNo,money);
    }

    @Override
    public String closeOrder(String orderNo) {
        return AliPayUtils.closeOrder(aliPayConfig,orderNo);
    }
}
