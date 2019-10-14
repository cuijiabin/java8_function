package com.function.log;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author cuijiabin
 */
public class LogDemo {

    private static Logger logger = Logger.getLogger(LogDemo.class);

    /**
     * @param args
     */
    public static void main(String[] args) {

        logger.debug("This is debug message.");
        logger.info("This is info message.");
        logger.error("This is error message.");

        //1、截取，substring
        String str = "((num = '2000'))";

        int first = str.indexOf("'");//单引号第一次出现的位置
        int end = str.lastIndexOf("'");//单引号最后一次出现的位置
        String strNew = str.substring(first + 1, end);
        System.out.println(strNew);

        //2、StringUtils.substringBetween（String str, String open, String close）
        String s = StringUtils.substringBetween(str, "= '", "')");
        System.out.println(s);

        //3、正则
        Pattern pattern = Pattern.compile("([\'\"])(.*?)\\1");
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()){
            int i = matcher.groupCount();
            String group = matcher.group(2);
            System.out.println(group);
        }

    }

}
