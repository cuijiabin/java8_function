package com.function.demo;

import com.alibaba.druid.support.json.JSONUtils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.util.*;

public class SmsUtil {

    private static String SERVIVE_URL = "http://sms.intra.miyabaobei.com/sms/index";

    private static final String[] HEX_DIGITS = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    public static StringBuilder dataSort(Map<String, Object> map) {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            builder.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder;
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n += 256;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return HEX_DIGITS[d1] + HEX_DIGITS[d2];
    }

    private static String byteArrayToHexString(byte[] b) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            buffer.append(byteToHexString(b[i]));
        }
        return buffer.toString();
    }

    public static String MD5Encode(String content) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        String resultString = byteArrayToHexString(md.digest(content.getBytes("utf-8")));
        return resultString;
    }

    public static String sendMsg(Map<String, Object> map) throws Exception {
        List<NameValuePair> urlParameters = new ArrayList<>();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            urlParameters.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString()));
        }

        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(SERVIVE_URL);

        post.setEntity(new UrlEncodedFormEntity(urlParameters, "UTF-8"));
        post.addHeader("User-Agent", "Mozilla/4.0");
        post.addHeader("Content-Type", "application/x-www-form-urlencoded; text/html; charset=" + "utf-8");

        HttpResponse response = client.execute(post);

        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        return result.toString();
    }

    public static void main(String[] args) {

        Random random = new Random();
        String smscode = "";
        for (int i = 0; i < 4; i++) {
            smscode += random.nextInt(10);
        }
        System.out.println(smscode);

        Map<String, Object> map = new TreeMap<>();
        String timestamp = String.valueOf(System.currentTimeMillis() / 1000);
        map.put("method", "mia.send.note.template");
        map.put("time", timestamp);
        map.put("timely", 1);
        map.put("useOfDept", "POP_API");
        map.put("mobile", "18910358924");
//        map.put("iOrderId", "1821023358811");
        map.put("tempId", 3127);
        map.put("channel", 1009);

        Map<String, String> json = new HashMap<>(2);
        json.put("随机登录密码", smscode);
        map.put("content", JSONUtils.toJSONString(json));

        StringBuilder builder = dataSort(map);

        builder.append("mia");
        builder.insert(0, "mia");

        try {
            map.put("token", MD5Encode(builder.toString()));
            System.out.println(map.get("token"));
            System.out.println(map);
            String result = sendMsg(map);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
