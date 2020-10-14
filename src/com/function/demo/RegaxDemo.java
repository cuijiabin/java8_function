package com.function.demo;

import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegaxDemo {
    public static void main(String[] args) {
        String textContext = "我的手机号码为:188000000007,请惠存！！！";
        String phoneNum = getPhoneNum(textContext);
        System.out.println(phoneNum);//18800000000

        Map<String, String> tMap = new TreeMap<>();
    }

    //提取文本手机号
    public static String getPhoneNum(String text) {
        Pattern compile = Pattern.compile("[\\d]{11}");
        Matcher matcher = compile.matcher(text);

        while (matcher.find()) {
            return matcher.group();
        }
        return null;
    }

}
