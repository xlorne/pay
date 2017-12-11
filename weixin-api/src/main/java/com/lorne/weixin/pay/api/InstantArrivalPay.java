package com.lorne.weixin.pay.api;

import com.lorne.weixin.pay.util.WeixinApiUtils;

import java.util.Map;

/**
 * 二维码支付
 * Created by yuliang on 2016/3/28.
 */
public class InstantArrivalPay extends AbstractWxPay {


    @Override
    public Map<String, Object> createPay() {
        return WeixinApiUtils.createOrder(payInfo.getConfig(),payInfo.getTradeNo(), payInfo.getSubject(), payInfo.getBody(), payInfo.getPrice(), "", NATIVE);
    }


}
