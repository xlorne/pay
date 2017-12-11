//package com.lorne.weixin.pay.service;
//
//import com.lorne.weixin.pay.model.WxConfig;
//import com.lorne.weixin.pay.util.LogUtils;
//import com.lorne.weixin.pay.util.WeixinApiUtils;
//import com.lorne.weixin.pay.util.XMLParser;
//import org.springframework.stereotype.Component;
//
//import java.util.Map;
//
///**
// * Created by yuliang on 2016/11/16.
// */
//@Component
//public class WxNotifyService {
//
//     public String notifyOrder(String xml, INotifyBack back, WxConfig wxConfig) {
//          String flag = "SUCCESS";
//          String msg = "OK";
//          try {
//               Map<String, Object> map = XMLParser.getMapFromXML(xml);
//               LogUtils.logResult("微信回调参数",map.toString());
//               if (map != null) {
//                    if ("SUCCESS".equals(map.get("return_code"))) {
//                         String out_trade_no = (String)map.get("out_trade_no");// 商户订单号
//                         String out_trade_no = (String)map.get("out_trade_no");// 商户订单号
//                         String transactionId =(String) map.get("transaction_id");// 微信支付订单号
//                         if (back != null) {
//                              if (WeixinApiUtils.hasOrder(wxConfig, out_trade_no)) {
//                                   back.success(out_trade_no, transactionId, map);
//                              }
//                         }
//                    }
//               }
//          } catch (Exception e) {
//               flag = "FAIL";
//               msg = e.getLocalizedMessage();
//          }
//          String res = "<xml>\n" +
//                  "  <return_code><![CDATA[" + flag + "]]></return_code>\n" +
//                  "  <return_msg><![CDATA[" + msg + "]]></return_msg>\n" +
//                  "</xml>";
//          return res;
//     }
//}
