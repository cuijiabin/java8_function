package com.function.es;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import org.apache.http.entity.ContentType;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Map;

import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;

/**
 * @Author: cuijiabin
 * @Date: 2021/9/14 15:47
 */
public class DingDingTalk {

    static String server = "https://oapi.dingtalk.com/robot/send";
    static String accessToken = "b2788fa85511ba19dff09947f804e9c453c6132724dc82cd08829631ee03d705";
    static String secret = "SEC3b2ef9cdfe925d27395c14096c46605d564939a585558070e0e2a116f601cf4f";
    static String msgKW = "tt机器人消息";

    /**
     * 获取钉钉机器人消息发送授权签名
     *
     * @param timestamp 时间戳
     * @return
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     */
    public static String getSign(long timestamp)
            throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
        // 实例化 mac
        Mac mac = Mac.getInstance("HmacSHA256");
        // 还原密钥，并初始化 mac
        mac.init(new SecretKeySpec(secret.getBytes("UTF-8"), "HmacSHA256"));
        // 签名拼接
        String stringToSign = timestamp + "\n" + secret;
        // 执行消息摘要
        byte[] signData = mac.doFinal(stringToSign.getBytes("UTF-8"));
        // 对消息摘要进行 Base64 编码，再进行 URL 编码
        return URLEncoder.encode(new String(Base64.getEncoder().encode(signData)), "UTF-8");
    }

    public static String sendDingMsg(String msg, String[] atMobiles) {
        try {
            // 时间戳
            Long timestamp = System.currentTimeMillis();
            String sign = getSign(timestamp);
//            String url = server + "?access_token=" + accessToken + "&timestamp=" + timestamp + "&sign=" + sign;
            String url = server + "?access_token=" + accessToken;
            Map<String, Object> sendMsg = Maps.newHashMap();
            // 消息类型:文本
            sendMsg.put("msgtype", "markdown");
            // 消息体
            Map<String, Object> text = Maps.newHashMap();
            text.put("title", msgKW);
            text.put("text", msg);
            sendMsg.put("markdown", text);
            // 提醒谁看
            Map<String, Object> at = Maps.newHashMap();
            if (atMobiles == null || atMobiles.length == 0) {
                at.put("isAtAll", 0);
            } else {
                at.put("atMobiles", atMobiles);
                at.put("isAtAll", 0);
            }
            sendMsg.put("at", at);

            String jsonMsg = JSON.toJSONString(sendMsg);
            // 发送消息
            String restult = sendPost(jsonMsg, url);
            return restult;
        } catch (Exception e) {

            return "发送钉钉消息异常";
        }
    }

    public static String sendPost(String json, String url) {

        try {
            Content content = Request.Post(url).bodyString(json, ContentType.APPLICATION_JSON).execute()
                    .returnContent();
            return content.asString();
        } catch (Exception ex) {

            return "{\"error\":\"error\"}";
        }
    }

    public static void main(String[] args) {
        String result = sendDingMsg("#### 钉钉群聊自义定机器人设置与消息发送wiki已完成 wiki:http://wiki.mia.com/pages/viewpage.action?pageId=9188706 \\n> 消息不加签名 \\n> \n> ###### 10点20分发布 [csv文件下载](http://uploads.miyabaobei.com/resources/d1/p6/ums_data_file/finance_statistics/93001/2021/09/%E6%B8%A0%E9%81%93%E8%AE%A2%E5%8D%95%E5%88%97%E8%A1%A8%E5%AF%BC%E5%87%BA%E4%B8%8B%E8%BD%BD_20210914162601_7662.csv) \\n", null);
        System.err.println(result);
    }
}
