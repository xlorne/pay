package com.hou.alifacepay.pay;

/**
 * Created by houcunlu on 2017/10/17.
 */
public class AliFacePayConfig {


    public static   String Url = "https://openapi.alipay.com/gateway.do";

//  APPID即创建应用后生成
    public static String APP_ID ;

//  开发者应用私钥
    public static String APP_PRIVATE_KEY ;

//  参数返回格式，只支持json json（固定）
    public static String  FORMAT ="json";

//  请求和签名使用的字符编码格式，支持GBK和UTF-8 开发者根据实际工程编码配置
    public static String   CHARSET ="UTF-8";

//   ALIPAY_PUBLIC_KEY 支付宝公钥
    public static String ALIPAY_PUBLIC_KEY ;

//   SIGN_TYPE 商户生成签名字符串所使用的签名算法类型，目前支持RSA2和RSA，推荐使用RSA2 RSA2
    public static  String  SIGN_TYPE ;

    static {

        APP_ID = PropertiesUtils.getProperties("aliPay.properties","APP_ID");
        if("".equals(APP_ID)){
           throw  new NullPointerException("支付宝当面付参数为空！");
        }

        APP_PRIVATE_KEY = PropertiesUtils.getProperties("aliPay.properties","APP_PRIVATE_KEY");
        if("".equals(APP_PRIVATE_KEY)){
            throw  new NullPointerException("支付宝当面付参数为空！");
        }

        ALIPAY_PUBLIC_KEY = PropertiesUtils.getProperties("aliPay.properties","ALIPAY_PUBLIC_KEY");
        if("".equals(ALIPAY_PUBLIC_KEY)){
            throw  new NullPointerException("支付宝当面付参数为空！");
        }

        SIGN_TYPE = PropertiesUtils.getProperties("aliPay.properties","SIGN_TYPE");
        if("".equals(SIGN_TYPE)){
            throw  new NullPointerException("支付宝当面付参数为空！");
        }

    }



}
