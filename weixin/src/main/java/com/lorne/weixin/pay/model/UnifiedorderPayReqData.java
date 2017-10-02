package com.lorne.weixin.pay.model;

import com.lorne.weixin.pay.util.RandomStringGenerator;
import com.lorne.weixin.pay.util.Signature;

public class UnifiedorderPayReqData  extends MapXml {


    // 每个字段具体的意思请查看API文档
    private String appid = "";
    private String mch_id = "";
    private String device_info = "";
    private String nonce_str = "";
    private String sign = "";
    private String body = "";
    private String detail = "";
    private String attach = "";
    private String out_trade_no = "";
    private String fee_type = "";
    private int total_fee = 0;
    private String spbill_create_ip = "";
    private String time_start = "";
    private String time_expire = "";
    private String goods_tag = "";
    private String notify_url = "";
    private String trade_type = "";
    private String product_id = "";
    private String openid = "";

    /**
     * 统一下单 应用场景
     * 除被扫支付场景以外，商户系统先调用该接口在微信支付服务后台生成预支付交易单，返回正确的预支付交易回话标识后再按扫码、JSAPI、
     * APP等不同场景生成交易串调起支付。
     *
     * @param appid            微信分配的公众账号ID[是]
     * @param mch_id           微信支付分配的商户号[是]
     * @param device_info      终端设备号(门店号或收银设备ID)，注意：PC网页或公众号内支付请传"WEB"[否]
     * @param body             商品或支付单简要描述[是]
     * @param detail           商品名称明细列表[否]
     * @param attach           附加数据，在查询API和支付通知中原样返回，该字段主要用于商户携带订单的自定义数据[否]
     * @param out_trade_no     商户系统内部的订单号,32个字符内、可包含字母, 其他说明见商户订单号[是]
     * @param fee_type         符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型[否]
     * @param total_fee        订单总金额，只能为整数，详见支付金额[是]
     * @param spbill_create_ip APP和网页支付提交用户端ip，Native支付填调用微信支付API的机器IP。[是]
     * @param time_start       订单生成时间，格式为yyyyMMddHHmmss，如2009 年12月25日9点10分10秒表示为20091225091010
     *                         。其他详见时间规则[否]
     * @param time_expire      订单失效时间，格式为yyyyMMddHHmmss，如2009年12月27日9点10分10秒表示为20091227091010
     *                         。其他详见时间规则。注意：最短失效时间间隔必须大于5分钟[否]
     * @param goods_tag        商品标记，代金券或立减优惠功能的参数，说明详见代金券或立减优惠[否]
     * @param notify_url       接收微信支付异步通知回调地址[是]
     * @param trade_type       取值如下：JSAPI，NATIVE，APP，WAP,详细说明见参数规定[是]
     * @param product_id       trade_type=NATIVE，此参数必传。此id为二维码中包含的商品ID，商户自行定义。[否]
     * @param openid           trade_type=JSAPI，此参数必传，用户在商户appid下的唯一标识。下单前需要调用【网页授权获取用户信息】
     *                         接口获取到用户的Openid。[否]
     */
    public UnifiedorderPayReqData(String key,String appid, String mch_id,
                                  String device_info, String body, String detail, String attach,
                                  String out_trade_no, String fee_type, int total_fee,
                                  String spbill_create_ip, String time_start, String time_expire,
                                  String goods_tag, String notify_url, String trade_type,
                                  String product_id, String openid) {
        super();
        this.appid = appid;
        this.mch_id = mch_id;
        this.device_info = device_info;
        this.body = body;

        this.detail = detail;
        this.attach = attach;
        this.out_trade_no = out_trade_no;
        this.fee_type = fee_type;
        this.total_fee = total_fee;
        this.spbill_create_ip = spbill_create_ip;
        this.time_start = time_start;
        this.time_expire = time_expire;
        this.goods_tag = goods_tag;
        this.notify_url = notify_url;
        this.trade_type = trade_type;
        this.product_id = product_id;
        this.openid = openid;

        // 随机字符串，不长于32 位
        setNonce_str(RandomStringGenerator.getRandomStringByLength(32));

        // 根据API给的签名规则进行签名
        String sign = Signature.getSign(toMap(),key);

        setSign(sign);// 把签名数据设置到Sign这个属性中

    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getMch_id() {
        return mch_id;
    }

    public void setMch_id(String mch_id) {
        this.mch_id = mch_id;
    }

    public String getDevice_info() {
        return device_info;
    }

    public void setDevice_info(String device_info) {
        this.device_info = device_info;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public void setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getFee_type() {
        return fee_type;
    }

    public void setFee_type(String fee_type) {
        this.fee_type = fee_type;
    }

    public int getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(int total_fee) {
        this.total_fee = total_fee;
    }

    public String getSpbill_create_ip() {
        return spbill_create_ip;
    }

    public void setSpbill_create_ip(String spbill_create_ip) {
        this.spbill_create_ip = spbill_create_ip;
    }

    public String getTime_start() {
        return time_start;
    }

    public void setTime_start(String time_start) {
        this.time_start = time_start;
    }

    public String getTime_expire() {
        return time_expire;
    }

    public void setTime_expire(String time_expire) {
        this.time_expire = time_expire;
    }

    public String getGoods_tag() {
        return goods_tag;
    }

    public void setGoods_tag(String goods_tag) {
        this.goods_tag = goods_tag;
    }

    public String getNotify_url() {
        return notify_url;
    }

    public void setNotify_url(String notify_url) {
        this.notify_url = notify_url;
    }

    public String getTrade_type() {
        return trade_type;
    }

    public void setTrade_type(String trade_type) {
        this.trade_type = trade_type;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

}
