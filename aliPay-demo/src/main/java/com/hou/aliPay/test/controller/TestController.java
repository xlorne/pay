package com.hou.aliPay.test.controller;

import com.hou.aliPay.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by houcunlu on 2017/10/19.
 */
@RestController
@RequestMapping("/test")
public class TestController {


    @Autowired
    private TestService testService;


    /**
     * 当面付 ： 条码支付
     * @param
     * @return
     */
    @RequestMapping("/barcodePay")
    public String barcodePay(@RequestParam("orderNo") String orderNo , @RequestParam("payCode") String payCode , @RequestParam("storeId") String storeId ) {

        return testService.barcodePay(orderNo , payCode , storeId);
    }





}
