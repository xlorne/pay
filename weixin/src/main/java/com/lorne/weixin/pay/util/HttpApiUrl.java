package com.lorne.weixin.pay.util;


public class HttpApiUrl {

    // 以下是几个API的路径：
    // 1）统一下单
    public static String PAY_UNFIFIEDORDER = "https://api.mch.weixin.qq.com/pay/unifiedorder";

    // 2）被扫支付查询API
    public static String PAY_QUERY_API = "https://api.mch.weixin.qq.com/pay/orderquery";

    // 3）申请退款API
    public static String PAY_REFUND_API = "https://api.mch.weixin.qq.com/secapi/pay/refund";

    // 4) 退款进度查询
    public static String PAY_REFUND_QUERY_API = "https://api.mch.weixin.qq.com/pay/refundquery";

    // 5) 关闭订单
    public static String PAY_CLOSE_ORDER_API = "https://api.mch.weixin.qq.com/pay/closeorder";

    // 6) 获取openid
    public static String JSCODE_SESSION_API = "https://api.weixin.qq.com/sns/jscode2session";

    // 7) 获取openid
    public static String PAY_ACCESS_TOKEN = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";

    // 8) 发送模板消息
    public static String SEND_MSG = "https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token=%s";

}


