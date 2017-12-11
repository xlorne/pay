package com.lorne.weixin.pay.service;

import java.util.Map;

/**
 * Created by yuliang on 2016/3/28.
 */
public interface INotifyBack {

    void success(String orderNumber, String transactionId, Map<String, Object> map);
}
