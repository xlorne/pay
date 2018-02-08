package com.lorne.weixin.pay.model;

import com.lorne.weixin.pay.util.RandomStringGenerator;
import com.lorne.weixin.pay.util.Signature;

public class TransfersReqData extends MapXml {



    // 每个字段具体的意思请查看API文档
    private String mch_appid = "";
    private String mchid = "";
    private String nonce_str = "";
    private String sign = "";
    private String partner_trade_no = "";
    private String openid = "";
    private String check_name = "";
    private String re_user_name = "";
    private int amount;
    private String desc;
    private String spbill_create_ip = "";


    public TransfersReqData(String key,String mch_appid, String mchid,
                            String partner_trade_no, String openid, String check_name,
                            String re_user_name, int amount, String desc, String spbill_create_ip) {
        this.mch_appid = mch_appid;
        this.mchid = mchid;
        this.partner_trade_no = partner_trade_no;
        this.openid = openid;
        this.check_name = check_name;
        this.re_user_name = re_user_name;
        this.amount = amount;
        this.desc = desc;
        this.spbill_create_ip = spbill_create_ip;


        // 随机字符串，不长于32 位
        setNonce_str(RandomStringGenerator.getRandomStringByLength(32));

        // 根据API给的签名规则进行签名
        String sign = Signature.getSign(toMap(),key);

        setSign(sign);// 把签名数据设置到Sign这个属性中
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getMchid() {
        return mchid;
    }

    public void setMchid(String mchid) {
        this.mchid = mchid;
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

    public String getMch_appid() {
        return mch_appid;
    }

    public void setMch_appid(String mch_appid) {
        this.mch_appid = mch_appid;
    }

    public String getPartner_trade_no() {
        return partner_trade_no;
    }

    public void setPartner_trade_no(String partner_trade_no) {
        this.partner_trade_no = partner_trade_no;
    }

    public String getCheck_name() {
        return check_name;
    }

    public void setCheck_name(String check_name) {
        this.check_name = check_name;
    }

    public String getRe_user_name() {
        return re_user_name;
    }

    public void setRe_user_name(String re_user_name) {
        this.re_user_name = re_user_name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getSpbill_create_ip() {
        return spbill_create_ip;
    }

    public void setSpbill_create_ip(String spbill_create_ip) {
        this.spbill_create_ip = spbill_create_ip;
    }
}
