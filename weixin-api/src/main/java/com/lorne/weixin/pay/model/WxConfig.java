package com.lorne.weixin.pay.model;

/**
 * Created by yuliang on 2016/11/16.
 */
public class WxConfig {


    /**
     * 商户号
     */
    private  String mchId;

    /**
     * appid
     */
    private  String appId;

    /**
     * API密钥
     */
    private  String key;

    /**
     * app_secret
     */
    private  String appSecret;


    /**
     * 证书密码
     */
    private  String certPassword;

    /**
     * 证书地址
     */
    private  String certLocalPath;

    /**
     * 回调地址
     */
    private String notifyUrl;


    public WxConfig(String mchId, String appId, String key, String appSecret, String certPassword, String certLocalPath, String notifyUrl) {
        this.mchId = mchId;
        this.appId = appId;
        this.key = key;
        this.appSecret = appSecret;
        this.certPassword = certPassword;
        this.certLocalPath = certLocalPath;
        this.notifyUrl = notifyUrl;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public WxConfig() {
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getCertPassword() {
        return certPassword;
    }

    public void setCertPassword(String certPassword) {
        this.certPassword = certPassword;
    }

    public String getCertLocalPath() {
        return certLocalPath;
    }

    public void setCertLocalPath(String certLocalPath) {
        this.certLocalPath = certLocalPath;
    }
}
