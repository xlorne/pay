package com.lorne.weixin.service.impl;

import com.github.wxpay.sdk.WXPay;
import com.lorne.weixin.WeixinService;
import com.lorne.weixin.bean.WXPayConfigImpl;
import org.springframework.stereotype.Service;

/**
 * create by lorne on 2017/9/25
 */
@Service
public class WeixinServiceImpl implements WeixinService {

    private WXPay wxpay;


    public WeixinServiceImpl() {
        try {
            WXPayConfigImpl  wxPayConfig = WXPayConfigImpl.getInstance();
            wxpay = new WXPay(wxPayConfig);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
