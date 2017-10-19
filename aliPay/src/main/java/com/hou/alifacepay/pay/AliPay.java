package com.hou.alifacepay.pay;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePayRequest;
import com.alipay.api.response.AlipayTradePayResponse;

/**
 * Created by houcunlu on 2017/10/17.
 */
public class AliPay {


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
    public static String barcodePay(String orderNo , String  payCode , String title , String storeId , String totalAmount   ) {
        AlipayClient alipayClient = new DefaultAlipayClient(
                AliFacePayConfig.Url,
                AliFacePayConfig.APP_ID,
                AliFacePayConfig.APP_PRIVATE_KEY,
                AliFacePayConfig.FORMAT,
                AliFacePayConfig.CHARSET,
                AliFacePayConfig.ALIPAY_PUBLIC_KEY,
                AliFacePayConfig.SIGN_TYPE);
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
            e.printStackTrace();
        }

        return response.getBody();
    }

}
