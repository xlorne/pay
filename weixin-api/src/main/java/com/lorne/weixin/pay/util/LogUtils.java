package com.lorne.weixin.pay.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: rizenguo
 * Date: 2014/10/23
 * Time: 14:59
 */
public class LogUtils {

    //打log用
    private static Logger logger = LoggerFactory.getLogger(LogUtils.class);


//
//    /**
//     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
//     *
//     * @param sWord 要写入日志里的文本内容
//     */
    public static void logResult(String tag,String sWord) {
        logger.info(String.format("%s\n--->\n%s",tag,sWord));
    }


}

