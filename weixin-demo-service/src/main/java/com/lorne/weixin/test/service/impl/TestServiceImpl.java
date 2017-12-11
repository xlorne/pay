package com.lorne.weixin.test.service.impl;

import com.lorne.core.framework.utils.KidUtils;
import com.lorne.weixin.pay.api.CreditCardPay;
import com.lorne.weixin.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * create by lorne on 2017/9/25
 */
@Service
public class TestServiceImpl implements TestService {


    @Autowired
    private CreditCardPay creditCardPay;


    /**
     * 刷卡支付
     * @param
     * @return
     */
    @Override
    public Map<String, Object> microPay(String authCode ,String subMchId,String outTradeNo ) {
        String  deviceInfo ="001";
        String  body ="商品描述";
        int  totalFee = 1;
        Map<String ,Object> map = creditCardPay.payMicropay(authCode,subMchId ,deviceInfo ,body ,outTradeNo , totalFee );
        return map;
    }


    @Override
    public Map<String, Object> queryOrder(String subMchId,String outTradeNo) {
        return creditCardPay.getOrderQuery(subMchId,outTradeNo);
    }

    @Override
    public boolean refundOrder(String subMchId,String outTradeNo, int money) {
        return creditCardPay.refundOrder(subMchId,outTradeNo, KidUtils.getKid(),money,money);
    }


    @Override
    public boolean closeOrder(String subMchId,String outTradeNo) {
        return creditCardPay.closeOrder(subMchId,outTradeNo);
    }
}
