package com.lorne.alipay.config;

/**
 * Created by houcunlu on 2017/10/17.
 */
public class AliPayConfig {

    public final static String URL = "https://openapi.alipay.com/gateway.do";

    //参数返回格式，只支持json json（固定）
    public final static String FORMAT = "json";

    //请求和签名使用的字符编码格式，支持GBK和UTF-8 开发者根据实际工程编码配置
    public final static String CHARSET = "UTF-8";

    //APPID即创建应用后生成
    private String appId;

    //开发者应用私钥
    private String appPrivateKey;

    //ALIPAY_PUBLIC_KEY 支付宝公钥
    private String alipayPublicKey;

    //SIGN_TYPE 商户生成签名字符串所使用的签名算法类型，目前支持RSA2和RSA，推荐使用RSA2 RSA2
    private String signType;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppPrivateKey() {
        return appPrivateKey;
    }

    public void setAppPrivateKey(String appPrivateKey) {
        this.appPrivateKey = appPrivateKey;
    }

    public String getAlipayPublicKey() {
        return alipayPublicKey;
    }

    public void setAlipayPublicKey(String alipayPublicKey) {
        this.alipayPublicKey = alipayPublicKey;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }
}
