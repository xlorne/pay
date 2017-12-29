package com.lorne.weixin.pay.api;

import com.lorne.core.framework.exception.ServiceException;
import com.lorne.weixin.pay.model.TemplateMsg;
import com.lorne.weixin.pay.model.WxConfig;
import com.lorne.weixin.pay.util.WeixinApiUtils;

import java.util.List;
import java.util.Map;

/**
 *
 * Created by yuliang on 2016/11/16.
 */
public class AbstractWxPay {

    public static final String APP = "APP";
    public static final String NATIVE = "NATIVE";
    public static final String JSAPI = "JSAPI";

    protected WxConfig wxConfig;

    public AbstractWxPay() {
    }

    public AbstractWxPay(WxConfig wxConfig) {
        this.wxConfig = wxConfig;
    }

    public void setPayInfo(WxConfig wxConfig) {
        this.wxConfig = wxConfig;
    }


    /**
     * 查询订单
     * @param sub_mch_id 子商户id
     * @param out_trade_no 订单编号
     * @return  订单结果数据
     */
    public Map<String, Object> getOrderQuery(String sub_mch_id,String out_trade_no) {
        return WeixinApiUtils.getOrderQuery(wxConfig,sub_mch_id, out_trade_no);
    }


    /**
     * 申请退款
     *
     * @param sub_mch_id 子商户Id
     * @param out_trade_no  订单号
     * @param out_refund_no 退款订单号
     * @param total_fee     订单金额
     * @param refund_fee    退款金额
     * @return  是否成功
     */
    public boolean refundOrder(String sub_mch_id,String out_trade_no, String out_refund_no, int total_fee, int refund_fee) {
        Map<String, Object> map = WeixinApiUtils.refundOrder(wxConfig, sub_mch_id,out_trade_no, out_refund_no, total_fee, refund_fee);
        if ("SUCCESS".equals(map.get("return_code"))) {
            if (map.containsKey("result_code")) {
                if ("SUCCESS".equals(map.get("result_code"))) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 退款进度查询
     *
     * @param sub_mch_id 子商户Id
     * @param out_trade_no 订单号
     * @return  订单信息
     */
    public Map<String, Object> refundQueryOrder(String sub_mch_id,String out_trade_no) {
        return WeixinApiUtils.refundQueryOrder(wxConfig,sub_mch_id, out_trade_no);
    }


    /**
     * 检查订单是否支付成功
     *
     * @param sub_mch_id 子商户Id
     * @param orderNumber 订单编号
     * @return 成功或失败
     */
    public boolean checkOrderHasPay(String  sub_mch_id,String orderNumber) {
        return WeixinApiUtils.hasOrder(wxConfig,sub_mch_id, orderNumber);
    }


    /**
     * 关闭订单
     * @param sub_mch_id 子商户Id
     * @param out_trade_no 订单号
     * @return  是否关闭
     */
    public boolean closeOrder(String  sub_mch_id,String out_trade_no) {
        return WeixinApiUtils.closeOrder(wxConfig,sub_mch_id, out_trade_no);
    }


    /**
     * 撤销订单
     * @param sub_mch_id 子商户Id
     * @param out_trade_no 订单号
     * @return  是否关闭
     */
    public boolean reverse(String  sub_mch_id,String out_trade_no) {
        return WeixinApiUtils.reverse(wxConfig,sub_mch_id, out_trade_no);
    }



    /**
     * 小程序获取用户openid与sessionkey
     *
     * @param jsCode 来自小程序的jscode
     * @return 详情见https://mp.weixin.qq.com/debug/wxadoc/dev/api/api-login.html?t=20161122
     * @throws ServiceException 业务异常
     */
    public Map<String, Object> getOpendIdAndSessionKey(String jsCode) throws ServiceException {
        return WeixinApiUtils.getOpendIdAndSessionKey(wxConfig, jsCode);
    }


    /**
     * 获取access_token
     * @return accessToken与时间
     * @throws ServiceException 业务异常
     */
    public Map<String, Object> getAccessToken () throws ServiceException {
        return WeixinApiUtils.getAccessToken(wxConfig);
    }


//
//    /**
//     * touser	是	接收者（用户）的 openid
//     template_id	是	所需下发的模板消息的id
//     page	否	点击模板卡片后的跳转页面，仅限本小程序内的页面。支持带参数,（示例index?foo=bar）。该字段不填则模板无跳转。
//     form_id	是	表单提交场景下，为 submit 事件带上的 formId；支付场景下，为本次支付的 prepay_id
//     value	是	模板内容，不填则下发空模板
//     color	否	模板内容字体的颜色，不填默认黑色
//     emphasis_keyword	否	模板需要放大的关键词，不填则默认无放大
//     * 发送模板消息
//     * @return  推送返回结果
//     * @throws ServiceException 业务异常
//     */
    public Map<String, Object> pushMsg(String accessToken,String touser,String templateId,String formId,List<TemplateMsg> value) throws ServiceException {
        return WeixinApiUtils.pushMsg(accessToken,touser,templateId,formId,value);
    }





    /**
     * 通过jscode赋值openid
     *
     * @param jsCode 小程序的openid
     * @return openId
     * @throws ServiceException 业务异常
     */
    public String getOpendIdByJsCode(String jsCode) throws ServiceException {
        Map<String, Object> map = getOpendIdAndSessionKey(jsCode);
        if (map != null) {
            return (String)map.get("openid");
        }
        throw new ServiceException("获取openId 失败.");
    }
}
