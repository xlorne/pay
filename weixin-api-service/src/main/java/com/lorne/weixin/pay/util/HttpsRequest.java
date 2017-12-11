package com.lorne.weixin.pay.util;

import com.lorne.weixin.pay.model.WxConfig;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.*;

/**
 * Created by yuliang on 2016/11/16.
 */
public class HttpsRequest {

    private WxConfig config;

    public interface ResultListener {


        public void onConnectionPoolTimeoutError();

    }


    //表示请求器是否已经做了初始化工作
    private boolean hasInit = false;

    //连接超时时间，默认10秒
    private int socketTimeout = 10000;

    //传输超时时间，默认30秒
    private int connectTimeout = 30000;

    //请求器的配置
    private RequestConfig requestConfig;

    //HTTP请求器
    private CloseableHttpClient httpClient;

    public HttpsRequest(WxConfig config) throws UnrecoverableKeyException, KeyManagementException, NoSuchAlgorithmException, KeyStoreException, IOException {
        this.config =config;
        init();
    }

    private void init() throws IOException, KeyStoreException, UnrecoverableKeyException, NoSuchAlgorithmException, KeyManagementException {

        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        FileInputStream instream = new FileInputStream(new File(config.getCertLocalPath()));//加载本地的证书进行https加密传输
        try {
            keyStore.load(instream,config.getCertPassword().toCharArray());//设置证书密码
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            instream.close();
        }

        // Trust own CA and all self-signed certs
        SSLContext sslcontext = SSLContexts.custom()
                .loadKeyMaterial(keyStore, config.getCertPassword().toCharArray())
                .build();
        // Allow TLSv1 protocol only
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
                sslcontext,
                new String[]{"TLSv1"},
                null,
                SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);

        httpClient = HttpClients.custom()
                .setSSLSocketFactory(sslsf)
                .build();

        //根据默认超时限制初始化requestConfig
        requestConfig = RequestConfig.custom().setSocketTimeout(socketTimeout).setConnectTimeout(connectTimeout).build();

        hasInit = true;
    }

//    /**
//     * 通过Https往API post xml数据
//     *
//     * @param url    API地址
//     * @param xmlObj 要提交的XML数据对象
//     * @return API回包的实际数据
//     * @throws IOException
//     * @throws KeyStoreException
//     * @throws UnrecoverableKeyException
//     * @throws NoSuchAlgorithmException
//     * @throws KeyManagementException
//     */

    public String sendPost(String url, String xmlObj) throws IOException, KeyStoreException, UnrecoverableKeyException, NoSuchAlgorithmException, KeyManagementException {

        if (!hasInit) {
            init();
        }

        String result = null;

        HttpPost httpPost = new HttpPost(url);

        //得指明使用UTF-8编码，否则到API服务器XML的中文不能被成功识别
        StringEntity postEntity = new StringEntity(xmlObj, "UTF-8");
        httpPost.addHeader("Content-Type", "text/xml");
        httpPost.setEntity(postEntity);

        //设置请求器的配置
        httpPost.setConfig(requestConfig);

        try {
            HttpResponse response = httpClient.execute(httpPost);

            HttpEntity entity = response.getEntity();

            result = EntityUtils.toString(entity, "UTF-8");

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            httpPost.abort();
        }

        return result;
    }


}
