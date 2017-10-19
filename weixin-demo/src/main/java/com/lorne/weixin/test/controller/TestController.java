package com.lorne.weixin.test.controller;

import com.lorne.core.framework.exception.ServiceException;
import com.lorne.weixin.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * create by lorne on 2017/9/30
 */
@RestController
@RequestMapping("/test")
public class TestController {


    @Autowired
    private TestService testService;

    @RequestMapping("/index")
    public Map<String,Object> index(@RequestParam("openId") String openId) throws ServiceException{
        return testService.createOrder(openId);
    }


    /**
     * 刷卡支付
     * @param
     * @return
     * @throws ServiceException
     */
    @RequestMapping("/microPay")
    public Map<String,Object> microPay(@RequestParam("authCode") String authCode , @RequestParam("outTradeNo") String outTradeNo) throws ServiceException{
        return testService.microPay(authCode , outTradeNo);
    }


}
