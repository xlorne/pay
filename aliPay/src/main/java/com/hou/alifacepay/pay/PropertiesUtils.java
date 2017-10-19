package com.hou.alifacepay.pay;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by houcunlu on 2017/7/24.
 */
public class PropertiesUtils {

    public static String getProperties (String fileName , String parameter){
        Properties  properties = new Properties();
        // 读取SRC下配置文件 --- 属于读取内部文件
        try {
            properties.load(PropertiesUtils.class.getResourceAsStream("/"+fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String  controlPath = properties.getProperty(parameter);
        return  controlPath;
    }


}
