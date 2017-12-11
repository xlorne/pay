package com.lorne.weixin.pay.model;


/**
 * Created by yuliang on 2016/11/16.
 */
public class PayInfo {

    private String tradeNo;
    private String subject;
    private String body;
    private int price;
    private String openId;

    private WxConfig config;

    public WxConfig getConfig() {
        return config;
    }


    public void setConfig(WxConfig config) {
        this.config = config;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }
}
