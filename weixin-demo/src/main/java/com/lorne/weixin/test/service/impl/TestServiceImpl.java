package com.lorne.weixin.test.service.impl;

import com.lorne.core.framework.exception.ServiceException;
import com.lorne.core.framework.utils.KidUtils;
import com.lorne.weixin.pay.api.AccountPay;
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

    @Autowired
    private AccountPay accountPay;


    /**
     * 刷卡支付
     * @param
     * @return
     */
    @Override
    public Map<String, Object> microPay(String authCode ,String outTradeNo ) {
        String  deviceInfo ="001";
        String  body ="商品描述";
        int  totalFee = 1;
        Map<String ,Object> map = creditCardPay.payMicropay(authCode ,deviceInfo ,body ,outTradeNo , totalFee );
        return map;
    }


    @Override
    public Map<String, Object> queryOrder(String outTradeNo) {
        return creditCardPay.getOrderQuery(outTradeNo);
    }

    @Override
    public boolean refundOrder(String outTradeNo, int money) {
        return creditCardPay.refundOrder(outTradeNo, KidUtils.getKid(),money,money);
    }


    @Override
    public boolean closeOrder(String outTradeNo) {
        return creditCardPay.closeOrder(outTradeNo);
    }


    @Override
    public Map<String, Object> transfers(String openid, int amount) {
        String partner_trade_no = KidUtils.getKid();
        return creditCardPay.transfers(partner_trade_no,openid,"NO_CHECK","",amount,"奖金","192.168.2.1");
    }



    @Override
    public Map<String, Object> accountPay(int amount, String openId) {
        String tradeNo = KidUtils.getKid();
        return accountPay.createPay(tradeNo,"小走","契约金",amount,openId);
    }

    @Override
    public Map<String, Object> getOpenId(String code) {
        try {
            return accountPay.getOpendIdAndSessionKey(code);
        } catch (ServiceException e) {
            e.printStackTrace();
            return null;
        }
    }
}
