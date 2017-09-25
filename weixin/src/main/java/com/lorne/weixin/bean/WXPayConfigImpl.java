package com.lorne.weixin.bean;

import com.github.wxpay.impl.WXPayDomainSimpleImpl;
import com.github.wxpay.sdk.IWXPayDomain;
import com.github.wxpay.sdk.WXPayConfig;
import com.lorne.core.framework.utils.config.ConfigHelper;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class WXPayConfigImpl extends WXPayConfig {

    private byte[] certData;
    private static WXPayConfigImpl INSTANCE;


    private String appId;

    private String key;

    private String mchId;

    private String primaryDomain;

    private String alternateDomain;



    private WXPayConfigImpl() throws Exception{
        ConfigHelper configHelper = new ConfigHelper("weixin.properties");

        String certPath = configHelper.getStringValue("certPath");
        appId = configHelper.getStringValue("appId");
        key = configHelper.getStringValue("key");
        mchId = configHelper.getStringValue("mchId");

        primaryDomain = configHelper.getStringValue("primaryDomain");
        alternateDomain = configHelper.getStringValue("alternateDomain");



        File file = new File(certPath);
        InputStream certStream = new FileInputStream(file);
        this.certData = new byte[(int) file.length()];
        certStream.read(this.certData);
        certStream.close();

    }




    public static WXPayConfigImpl getInstance() throws Exception{
        if (INSTANCE == null) {
            synchronized (WXPayConfigImpl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new WXPayConfigImpl();
                }
            }
        }
        return INSTANCE;
    }



    public String getAppID() {
        return appId;
    }

    public String getMchID() {
        return mchId;
    }

    public String getKey() {
        return key;
    }

    public InputStream getCertStream() {
        ByteArrayInputStream certBis;
        certBis = new ByteArrayInputStream(this.certData);
        return certBis;
    }


    public int getHttpConnectTimeoutMs() {
        return 2000;
    }

    public int getHttpReadTimeoutMs() {
        return 10000;
    }

    public IWXPayDomain getWXPayDomain() {
        return WXPayDomainSimpleImpl.instance();
    }

    public String getPrimaryDomain() {
        return primaryDomain;
    }

    public String getAlternateDomain() {
        return alternateDomain;
    }

    @Override
    public int getReportWorkerNum() {
        return 1;
    }

    @Override
    public int getReportBatchSize() {
        return 2;
    }
}
