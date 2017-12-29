package com.lorne.weixin.pay.model;

import com.lorne.weixin.pay.util.RandomStringGenerator;
import com.lorne.weixin.pay.util.Signature;

/**
 * Created by houcunlu on 2017/12/29.
 *  关闭订单
 *
 */
public class ReverseOrderReqData  extends MapXml {



    // 每个字段具体的意思请查看API文档
    private String appid = "";
    private String mch_id = "";
    private String sub_mch_id = "";
    private String nonce_str = "";
    private String sign = "";
    private String out_trade_no = "";



    public ReverseOrderReqData(String key,String appid, String mch_id,String sub_mch_id, String out_trade_no) {
        this.appid = appid;
        this.mch_id = mch_id;
        this.out_trade_no = out_trade_no;
        this.sub_mch_id = sub_mch_id;

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

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }




}
