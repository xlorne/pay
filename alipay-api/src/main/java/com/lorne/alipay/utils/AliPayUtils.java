package com.lorne.alipay.utils;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.*;
import com.alipay.api.response.*;
import com.lorne.alipay.config.AliPayConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by houcunlu on 2017/10/17.
 */
public class AliPayUtils {

    private static Logger logger = LoggerFactory.getLogger(AliPayUtils.class);


    /**
     * 当面付 ： 条码支付
     * @param orderNo  商户订单id
     * @param payCode  用户支付码
     * @param title    订单标题
     * @param storeId  商户id
     * @param totalAmount 总金额
     * @return  支付结果
     */
    public static String barcodePay(AliPayConfig payConfig, String orderNo , String  payCode , String title , String storeId , String totalAmount) {
        AlipayClient alipayClient = new DefaultAlipayClient(
                AliPayConfig.URL,
                payConfig.getAppId(),
                payConfig.getAppPrivateKey(),
                AliPayConfig.FORMAT,
                AliPayConfig.CHARSET,
                payConfig.getAlipayPublicKey(),
                payConfig.getSignType());
        AlipayTradePayRequest request = new AlipayTradePayRequest(); //创建API对应的request类
        request.setBizContent("{" +
                "    \"out_trade_no\":\""+orderNo+"\"," +
                "    \"scene\":\"bar_code\"," +
                "    \"auth_code\":\""+payCode+"\"," +
                "    \"subject\":\""+title+"\"," +
                "    \"store_id\":\""+storeId+"\"," +
                "    \"timeout_express\":\"2m\"," +
                "    \"total_amount\":\""+totalAmount+"\"" +
                "  }"); //设置业务参数

        System.out.println(request.getBizContent());
        AlipayTradePayResponse response = null; //通过alipayClient调用API，获得对应的response类
        try {
            response = alipayClient.execute(request);
        } catch (AlipayApiException e) {
            logger.error(e.getMessage());
            return null;
        }
        return response.getBody();
    }





    /**
     * 订单查询接口
     * @param payConfig 支付参数
     * @param orderNo   订单号
     * @return  订单详细
     */
    public static String queryOrder(AliPayConfig payConfig, String orderNo) {
        AlipayClient alipayClient = new DefaultAlipayClient(
                AliPayConfig.URL,
                payConfig.getAppId(),
                payConfig.getAppPrivateKey(),
                AliPayConfig.FORMAT,
                AliPayConfig.CHARSET,
                payConfig.getAlipayPublicKey(),
                payConfig.getSignType());
        AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
        request.setBizContent("{" +
                "\"out_trade_no\":\""+orderNo+"\""+
                "  }");
        AlipayTradeQueryResponse response = null;
        try {
            response = alipayClient.execute(request);
        } catch (AlipayApiException e) {
            logger.error(e.getMessage());
            return null;
        }
        return response.getBody();

    }



    /**
     * 退款接口
     * @param payConfig 支付参数
     * @param orderNo   订单号
     * @param refundAmount  退款金额
     * @return
     */
    public static String refundOrder(AliPayConfig payConfig, String orderNo,String refundAmount) {
        AlipayClient alipayClient = new DefaultAlipayClient(
                AliPayConfig.URL,
                payConfig.getAppId(),
                payConfig.getAppPrivateKey(),
                AliPayConfig.FORMAT,
                AliPayConfig.CHARSET,
                payConfig.getAlipayPublicKey(),
                payConfig.getSignType());
        AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
        request.setBizContent("{" +
                "\"out_trade_no\":\""+orderNo+"\"," +
                "\"refund_amount\":"+refundAmount+"" +
                "  }");
        AlipayTradeRefundResponse response = null;
        try {
            response = alipayClient.execute(request);
        } catch (AlipayApiException e) {
            logger.error(e.getMessage());
            return null;
        }
        return response.getBody();
    }


    /**
     * 关闭订单
     * @param payConfig 支付配置
     * @param orderNo   订单号
     * @return  订单信息
     */
    public static String closeOrder(AliPayConfig payConfig, String orderNo) {
        AlipayClient alipayClient = new DefaultAlipayClient(
                AliPayConfig.URL,
                payConfig.getAppId(),
                payConfig.getAppPrivateKey(),
                AliPayConfig.FORMAT,
                AliPayConfig.CHARSET,
                payConfig.getAlipayPublicKey(),
                payConfig.getSignType());

        AlipayTradeCloseRequest request = new AlipayTradeCloseRequest();
        request.setBizContent("{" +
                "\"out_trade_no\":\""+orderNo+"\"" +
                "  }");
        AlipayTradeCloseResponse response = null;
        try {
            response = alipayClient.execute(request);
        } catch (AlipayApiException e) {
            logger.error(e.getMessage());
            return null;
        }
        return response.getBody();
    }




    /**
     * 通过code获取token
     * @param payConfig 支付配置
     * @param code   code
     * @return  订单信息
     */
    public static String getAccessToken(AliPayConfig payConfig, String code) {
        AlipayClient alipayClient = new DefaultAlipayClient(
                AliPayConfig.URL,
                payConfig.getAppId(),
                payConfig.getAppPrivateKey(),
                AliPayConfig.FORMAT,
                AliPayConfig.CHARSET,
                payConfig.getAlipayPublicKey(),
                payConfig.getSignType());

        AlipayOpenAuthTokenAppRequest request = new AlipayOpenAuthTokenAppRequest();
        request.setBizContent("{" +
                "    \"grant_type\":\"authorization_code\"," +
                "    \"code\":\""+code+"\"" +
                "  }");
        AlipayOpenAuthTokenAppResponse response = null;
        try {
            response = alipayClient.execute(request);
        } catch (AlipayApiException e) {
            logger.error(e.getMessage());
            return null;
        }
        return response.getBody();
    }


    /**
     * 刷新token
     * @param payConfig 支付配置
     * @param token   token
     * @return  订单信息
     */
    public static String refreshAccessToken(AliPayConfig payConfig, String token) {
        AlipayClient alipayClient = new DefaultAlipayClient(
                AliPayConfig.URL,
                payConfig.getAppId(),
                payConfig.getAppPrivateKey(),
                AliPayConfig.FORMAT,
                AliPayConfig.CHARSET,
                payConfig.getAlipayPublicKey(),
                payConfig.getSignType());

        AlipayOpenAuthTokenAppRequest request = new AlipayOpenAuthTokenAppRequest();
        request.setBizContent("{" +
                "    \"grant_type\":\"authorization_code\"," +
                "    \"refresh_token\":\""+token+"\"" +
                "  }");
        AlipayOpenAuthTokenAppResponse response = null;
        try {
            response = alipayClient.execute(request);
        } catch (AlipayApiException e) {
            logger.error(e.getMessage());
            return null;
        }
        return response.getBody();
    }


    /**
     * 查询订单状态
     * @param payConfig 支付信息
     * @param token token
     * @return
     */
    public static String queryAccessToken(AliPayConfig payConfig, String token) {
        AlipayClient alipayClient = new DefaultAlipayClient(
                AliPayConfig.URL,
                payConfig.getAppId(),
                payConfig.getAppPrivateKey(),
                AliPayConfig.FORMAT,
                AliPayConfig.CHARSET,
                payConfig.getAlipayPublicKey(),
                payConfig.getSignType());

        AlipayOpenAuthTokenAppQueryRequest request = new AlipayOpenAuthTokenAppQueryRequest();
        request.setBizContent("{" +
                "    \"app_auth_token\":\""+token+"\"" +
                "  }");
        AlipayOpenAuthTokenAppQueryResponse response = null;
        try {
            response = alipayClient.execute(request);
        } catch (AlipayApiException e) {
            logger.error(e.getMessage());
            return null;
        }
        return response.getBody();
    }



}
