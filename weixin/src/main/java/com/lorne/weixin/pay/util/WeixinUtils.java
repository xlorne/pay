package com.lorne.weixin.pay.util;

import com.alibaba.fastjson.JSONObject;
import com.lorne.core.framework.utils.http.HttpUtils;
import com.lorne.weixin.pay.model.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeixinUtils {




    /**
     * 统一下单
     *
     * @param name      商品名称
     * @param total_fee 价格（单位：分）
     * @param ip        ip
     */
    public static Map<String, Object> payUnifiedorder(WxConfig config, String name, String detail, int total_fee, String ip, String out_trade_no, String openid, String trade_type) {

        UnifiedorderPayReqData unifiedorderPayReqData = new UnifiedorderPayReqData(config.getKey(),
                config.getAppId(), config.getMchId(), "", name, detail, "",
                out_trade_no, "", total_fee, ip, "", "", "",
                config.getNotifyUrl(), trade_type, "", openid);
        String postDataXML = unifiedorderPayReqData.toXml();
        LogUtils.logResult("请求统一下单参数", postDataXML);
        try {
            String res = HttpUtils.postXml(HttpApiUrl.PAY_UNFIFIEDORDER,
                    postDataXML);
            LogUtils.logResult("响应统一下单参数", res);
            Map<String, Object> map = XMLParser.getMapFromXML(res);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }


    public static Map<String, Object> refund(WxConfig config, String out_trade_no, String out_refund_no, int total_fee, int refund_fee) {
        RefundReqData reqData = new RefundReqData(config.getKey(), config.getAppId(), config.getMchId(), out_trade_no, out_refund_no, total_fee, refund_fee, config.getMchId());
        String postDataXML = reqData.toXml();
        LogUtils.logResult("请求申请退款", postDataXML);
        try {
            HttpsRequest httpsRequest = new HttpsRequest(config);
            String res = httpsRequest.sendPost(HttpApiUrl.PAY_REFUND_API, postDataXML);
            LogUtils.logResult("响应申请退款", res);
            Map<String, Object> map = XMLParser.getMapFromXML(res);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public static Map<String, Object> closeOrder(WxConfig config, String out_trade_no) {
        CloseOrderReqData reqData = new CloseOrderReqData(config.getKey(), config.getAppId(), config.getMchId(), out_trade_no);
        String postDataXML = reqData.toXml();
        LogUtils.logResult("请求关闭订单", postDataXML);
        try {
            String res = HttpUtils.postXml(HttpApiUrl.PAY_CLOSE_ORDER_API,
                    postDataXML);
            LogUtils.logResult("响应关闭订单", res);
            Map<String, Object> map = XMLParser.getMapFromXML(res);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public static Map<String, Object> refundQuery(WxConfig config, String out_trade_no) {
        RefundQueryReqData reqData = new RefundQueryReqData(config.getKey(), config.getAppId(), config.getMchId(), out_trade_no);
        String postDataXML = reqData.toXml();
        LogUtils.logResult("请求查询退款订单", postDataXML);
        try {
            String res = HttpUtils.postXml(HttpApiUrl.PAY_REFUND_QUERY_API,
                    postDataXML);
            LogUtils.logResult("响应查询退款订单", res);

            Map<String, Object> map = XMLParser.getMapFromXML(res);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Map<String, Object> payOrderquery(WxConfig config, String out_trade_no) {
        ScanPayQueryReqData scanPayQueryReqData = new ScanPayQueryReqData(config, null,
                out_trade_no);
        String postDataXML = scanPayQueryReqData.toXml();
        LogUtils.logResult("请求查询订单", postDataXML);
        try {
            String res = HttpUtils
                    .postXml(HttpApiUrl.PAY_QUERY_API, postDataXML);
            LogUtils.logResult("响应查询订单", res);

            Map<String, Object> map = XMLParser.getMapFromXML(res);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Map<String, Object> jscode2session(WxConfig config, String jsCode) {
        String url = HttpApiUrl.JSCODE_SESSION_API + "?appid=" + config.getAppId() + "&secret=" + config.getAppSecret() + "&js_code=" + jsCode + "&grant_type=authorization_code";
        Map<String, Object> map = null;
        String res = HttpUtils.get(url);
        LogUtils.logResult("获取sessionKey与opendId订单", res);
        try {
            map = JSONObject.parseObject(res);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return map;
    }


    public static Map<String, Object> getAccessToken(WxConfig config) {
        String url = String.format(HttpApiUrl.PAY_ACCESS_TOKEN, config.getAppId(), config.getAppSecret());
        Map<String, Object> map = null;
        String res = HttpUtils.get(url);
        LogUtils.logResult("获取ACCESS_TOKEN", res);
        try {
            map = JSONObject.parseObject(res);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return map;
    }

    public static Map<String, Object> pushMsg(String accessToken, String touser, String templateId, String formId, List<TemplateMsg> value) {
        String url = String.format(HttpApiUrl.SEND_MSG, accessToken);

        Map<String, Object> data = new HashMap<>();
        data.put("touser", touser);
        data.put("template_id", templateId);
        data.put("form_id", formId);
        Map<String, Object> msgs = new HashMap<>();
        for (int i = 0; i < value.size(); i++) {
            TemplateMsg msg = value.get(i);
            msgs.put("keyword" + (i + 1), msg);
        }
        data.put("data", msgs);
        String json = new JSONObject(data).toJSONString();
        System.out.println(json);
        String res = HttpUtils.postJson(url, json);
        LogUtils.logResult("发送模板消息", res);
        Map<String, Object> map = null;
        try {
            map = JSONObject.parseObject(res);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return map;
    }
}
