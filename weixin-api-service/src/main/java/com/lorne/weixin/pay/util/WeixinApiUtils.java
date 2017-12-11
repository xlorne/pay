package com.lorne.weixin.pay.util;

import com.lorne.core.framework.exception.ServiceException;
import com.lorne.weixin.pay.api.AbstractWxPay;
import com.lorne.weixin.pay.model.TemplateMsg;
import com.lorne.weixin.pay.model.WxConfig;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 微信支付 订单类
 *
 * @author menghuan
 */
public class WeixinApiUtils {


    public static Map<String, Object> createOrder(WxConfig config, String tradeNo, String subject,
                                                  String body, int price, String openid, String tradeType) {
        // app支付客户端ip
        String ip = "127.0.0.1";
        /**
         * 调用统一支付接口
         */
        Map<String, Object> map = WeixinUtils.payUnifiedorder(config, subject, body, price, ip, tradeNo, openid, tradeType);
        Map<String, Object> outParams = new HashMap<String, Object>();
        if (null != map) {
            String app_id = (String)map.get("appid");
            /**
             * 获取预支付id
             */
            String prepayid =  (String)map.get("prepay_id");

            String code_url = (String) map.get("code_url");

            /**
             * 创建预支付sign签名
             */
            String noceStr = RandomStringGenerator.getRandomStringByLength(32);
            String timeStamp = String
                    .valueOf((System.currentTimeMillis() / 1000));
            Map m = new HashMap();
            m.put("appId", app_id);
            m.put("nonceStr", noceStr);
            m.put("package", "prepay_id=" + prepayid);
            m.put("signType", "MD5");
            m.put("timeStamp", timeStamp);
            String sign = Signature.getSign(m, config.getKey());

            /**
             * 返回手机端支付需要的全部参数
             */
            outParams.put("appid", config.getAppId());
            outParams.put("noncestr", noceStr);
            outParams.put("partnerid", config.getMchId());
            outParams.put("package", "Sign=WXPay");
            outParams.put("prepayid", prepayid);
            outParams.put("out_trade_no", tradeNo);
            outParams.put("timestamp", timeStamp);
            if (tradeType.equals(AbstractWxPay.NATIVE))
                outParams.put("code_url", code_url);
            outParams.put("sign", sign);

        } else {
            outParams.put("retcode", "-1");
            outParams.put("retmsg", "错误：获取不到Token");
        }
        return outParams;
    }


    public static Map<String, Object> getOrderQuery(WxConfig config,String sub_mch_id, String out_trade_no) {
        return WeixinUtils.payOrderquery(config,sub_mch_id, out_trade_no);
    }


    public static Map<String, Object> refundOrder(WxConfig config,String sub_mch_id, String out_trade_no, String out_refund_no, int total_fee, int refund_fee) {
        return WeixinUtils.refund(config,sub_mch_id, out_trade_no, out_refund_no, total_fee, refund_fee);
    }


    public static Map<String, Object> refundQueryOrder(WxConfig config,String sub_mch_id, String out_trade_no) {
        return WeixinUtils.refundQuery(config,sub_mch_id, out_trade_no);
    }

    public static boolean closeOrder(WxConfig config,String sub_mch_id, String out_trade_no) {
        Map<String, Object> map = WeixinUtils.closeOrder(config,sub_mch_id, out_trade_no);
        if (null != map) {
            String return_code = (String)map.get("return_code");
            String result_code = (String)map.get("result_code");
            if (return_code.equals("SUCCESS") && result_code.equals("SUCCESS")) {
                // 订单状态
                return "OK".equals(map.get("return_msg"));
            }
        }
        return false;
    }

    public static boolean hasOrder(WxConfig config,String sub_mch_id, String out_trade_no) {
        Map<String, Object> map = getOrderQuery(config,sub_mch_id, out_trade_no);
        if (null != map) {
            String return_code =(String) map.get("return_code");
            String result_code = (String)map.get("result_code");
            if (return_code.equals("SUCCESS") && result_code.equals("SUCCESS")) {
                // 订单状态
                return "SUCCESS".equals(map.get("trade_state"));
            }
        }
        return false;
    }

    public static Map<String, Object> getOpendIdAndSessionKey(WxConfig config, String jsCode)throws ServiceException {
        Map<String, Object> map = WeixinUtils.jscode2session(config, jsCode);
        System.out.println(map);
        if (map.containsKey("errcode")) {
            throw new ServiceException("jscode失效");
        }
        return map;
    }


    public static Map<String, Object> getAccessToken(WxConfig config)throws ServiceException {
        Map<String, Object> map = WeixinUtils.getAccessToken(config);
        if (!map.containsKey("access_token")) {
            throw new ServiceException("获取access_token失败");
        }
        return map;
    }


    public static Map<String,Object> pushMsg(String accessToken, String touser, String templateId, String formId, List<TemplateMsg> value) {
        Map<String, Object> map = WeixinUtils.pushMsg(accessToken,touser,templateId,formId,value);
        return map;
    }
}
