package com.lorne.weixin.pay.model;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuliang on 2016/11/16.
 */
public abstract class MapXml {

    public String toXml() {
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        sb.append("<xml>");
        Map<String, Object> map = new HashMap<String, Object>();
        Field[] fields = getClass().getDeclaredFields();
        for (Field field : fields) {
            Object obj;
            try {
                field.setAccessible(true);
                obj = field.get(this);
                if (obj != null) {
                    if (obj instanceof String) {
                        String str = (String) obj;
                        if (!"".equals(str)) {
                            map.put(field.getName(), obj);
                            sb.append("<" + field.getName() + "><![CDATA[" + obj + "]]></" + field.getName() + ">");
                        }
                    } else {
                        map.put(field.getName(), obj);
                        sb.append("<" + field.getName() + "><![CDATA[" + obj + "]]></" + field.getName() + ">");
                    }
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        sb.append("</xml>");
        return sb.toString();
    }


    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<String, Object>();
        Field[] fields = getClass().getDeclaredFields();
        for (Field field : fields) {
            Object obj;
            try {
                field.setAccessible(true);
                obj = field.get(this);
                if (obj != null) {
                    if (obj instanceof String) {
                        String str = (String) obj;
                        if (!"".equals(str)) {
                            map.put(field.getName(), obj);
                        }
                    } else {
                        map.put(field.getName(), obj);
                    }
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return map;
    }
}
