package com.lorne.weixin.test.service;

import com.lorne.core.framework.exception.ServiceException;

import java.util.Map;

/**
 * create by lorne on 2017/9/25
 */
public interface TestService {


    Map<String, Object> createOrder(String openId) throws ServiceException;

}
