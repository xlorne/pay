package com.lorne.weixin.test.service.impl;

import com.lorne.core.framework.exception.ServiceException;
import com.lorne.core.framework.utils.KidUtils;
import com.lorne.weixin.pay.api.CreditCardPay;
import com.lorne.weixin.test.service.TestService;
import com.lorne.weixin.pay.api.AbstractWxPay;
import com.lorne.weixin.pay.api.AccountPay;
import com.lorne.weixin.pay.model.PayInfo;
import com.lorne.weixin.pay.model.WxConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * create by lorne on 2017/9/25
 */
@Service
public class TestServiceImpl implements TestService {


    @Autowired
    private WxConfig config;


    @Override
    public Map<String, Object> createOrder(String openId) throws ServiceException {
        String orderNo = KidUtils.getKid();
        AbstractWxPay abstractWxPay = new AccountPay();
        PayInfo payInfo = new PayInfo();
        payInfo.setBody("测试支付");
        int fen = 1;
        payInfo.setPrice(fen);
        payInfo.setSubject("测试支付");
        payInfo.setTradeNo(orderNo);

        payInfo.setConfig(config);

        payInfo.setOpenId(openId);
        abstractWxPay.setPayInfo(payInfo);
        Map<String, Object> map = abstractWxPay.createPay();
        map.put("orderNo", orderNo);
        return map;

    }


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
        Map<String ,Object> map = CreditCardPay.payMicropay(config ,authCode ,deviceInfo ,body ,outTradeNo , totalFee );
        return map;
    }










}
