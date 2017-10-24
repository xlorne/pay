package com.hou.alipay.utils;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePayRequest;
import com.alipay.api.response.AlipayTradePayResponse;
import com.hou.alipay.config.AliPayConfig;
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
     * @return
     * @throws AlipayApiException
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
        AlipayTradePayResponse response = null; //通过alipayClient调用API，获得对应的response类
        try {
            response = alipayClient.execute(request);
        } catch (AlipayApiException e) {
            logger.error(e.getMessage());
            return null;
        }
        return response.getBody();
    }

}
