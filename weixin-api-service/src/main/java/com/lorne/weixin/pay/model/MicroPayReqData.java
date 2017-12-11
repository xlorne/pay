package com.lorne.weixin.pay.model;

import com.lorne.weixin.pay.util.RandomStringGenerator;
import com.lorne.weixin.pay.util.Signature;

/**
 * Created by houcunlu on 2017/10/19.
 *
 *  提交刷卡支付
 */
public class MicroPayReqData  extends MapXml {



    private String appid = "";


    private String mch_id = "";

    private String sub_mch_id="";

    /**
     * 授权码  扫码支付授权码，设备读取用户微信中的条码或者二维码信息
      （注：用户刷卡条形码规则：18位纯数字，以10、11、12、13、14、15开头）
     */
    private String auth_code="";

    /**
     * 终端设备号(商户自定义，如门店编号)
     */
    private String device_info= "";

    /**
     * 随机字符串
     */
    private String  nonce_str= "";

    /**
     * 签名
     */
    private String  sign= "";

    /**
     * 商品描述
     */
    private String  body= "";

    /**
     * 商品详情
     */
    private String detail= "";

    /**
     * 商户订单号
     */
    private String out_trade_no= "";

    /**
     * 订单金额
     */
    private int total_fee = 0;


    /**
     * 终端IP
     */
    private String spbill_create_ip = "";




    public  MicroPayReqData(String appId , String mchId ,String subMchId, String authCode , String key , String deviceInfo ,String body,
                             String outTradeNo , int totalFee , String spbillCreateIp){

        appid=appId;
        mch_id = mchId;
        sub_mch_id = subMchId;
        auth_code = authCode;
        device_info = deviceInfo;
        this.body = body;
        out_trade_no = outTradeNo;
        total_fee = totalFee;
        spbill_create_ip = spbillCreateIp;

        // 随机字符串，不长于32 位
        setNonce_str(RandomStringGenerator.getRandomStringByLength(32));

        // 根据API给的签名规则进行签名
        String sign = Signature.getSign(toMap(),key);

        setSign(sign);// 把签名数据设置到Sign这个属性中
    }


    public String getSub_mch_id() {
        return sub_mch_id;
    }

    public void setSub_mch_id(String sub_mch_id) {
        this.sub_mch_id = sub_mch_id;
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

    public String getAuth_code() {
        return auth_code;
    }

    public void setAuth_code(String auth_code) {
        this.auth_code = auth_code;
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

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
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
}
