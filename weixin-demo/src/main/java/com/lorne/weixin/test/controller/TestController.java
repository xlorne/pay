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


    /**
     * 企业支付
     * @param
     * @return
     * @throws ServiceException
     */
    @RequestMapping("/transfers")
    public Map<String,Object> transfers(@RequestParam("openid") String openid,
                                        @RequestParam("amount") int amount) throws ServiceException{
        return testService.transfers(openid,amount);
    }


    /**
     * 小程序付款
     * @param
     * @return
     * @throws ServiceException
     */
    @RequestMapping("/accountPay")
    public Map<String,Object> accountPay(@RequestParam("price") int price,
                                         @RequestParam("openId") String openId) throws ServiceException{
        return testService.accountPay(price,openId);
    }


    /**
     * 小程序openId
     * @param
     * @return
     * @throws ServiceException
     */
    @RequestMapping("/getOpenId")
    public Map<String,Object> getOpenId(@RequestParam("code") String code) throws ServiceException{
        return testService.getOpenId(code);
    }

}
