package com.lorne.weixin.pay.model;

import com.lorne.weixin.pay.util.RandomStringGenerator;
import com.lorne.weixin.pay.util.Signature;

/**
 * Created by yuliang on 2016/11/16.
 */
public class CloseOrderReqData extends MapXml {


    // 每个字段具体的意思请查看API文档
    private String appid = "";
    private String mch_id = "";
    private String nonce_str = "";
    private String sign = "";
    private String out_trade_no = "";




    public CloseOrderReqData(String key,String appid, String mch_id, String out_trade_no) {
        this.appid = appid;
        this.mch_id = mch_id;
        this.out_trade_no = out_trade_no;

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
