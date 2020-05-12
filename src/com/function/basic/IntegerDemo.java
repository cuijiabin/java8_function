package com.function.basic;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.regex.Pattern;

public class IntegerDemo {
    //方法一：用JAVA自带的函数
    public static boolean isNumeric1(String str) {
        if (str == null) {
            return false;
        }
        for (int i = str.length(); --i >= 0; ) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /*方法二：推荐，速度最快
     * 判断是否为整数
     * @param str 传入的字符串
     * @return 是整数返回true,否则返回false
     */
    public static boolean isInteger2(String str) {
        if (str == null) {
            return false;
        }
//		Pattern pattern = Pattern.compile("^[-\\+]?[\\d].$");
        Pattern pattern = Pattern.compile("^[-\\+]?[0-9]+$");
        return pattern.matcher(str).matches();
    }

    //方法三：
    public static boolean isNumeric3(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }

    //方法四：
    public final static boolean isNumeric4(String s) {
        if (s != null && !"".equals(s.trim()))
            return s.matches("^[0-9]*$");
        else
            return false;
    }

    //方法五：用ascii码
    public static boolean isNumeric5(String str) {
        for (int i = str.length(); --i >= 0; ) {
            int chr = str.charAt(i);
            if (chr < 48 || chr > 57)
                return false;
        }
        return true;
    }

    @Test
    public void testInteger() {
        System.out.println(isInteger2("40"));
        System.out.println(isInteger2("-40"));
        System.out.println(isInteger2("-0"));
        System.out.println(isInteger2("0"));
        System.out.println(isInteger2("0.1"));
        System.out.println(isInteger2(null));
        System.out.println(isInteger2(""));
        System.out.println(isInteger2(""));
        System.out.println(isInteger2(" "));

        System.out.println("-------------------->");

        System.out.println(NumberUtils.isNumber("40"));
        System.out.println(NumberUtils.toInt("40"));
        System.out.println(NumberUtils.isNumber("-40"));
        System.out.println(NumberUtils.toInt("-40"));
        System.out.println(NumberUtils.isNumber("-0"));
        System.out.println(NumberUtils.toInt("-0"));
        System.out.println(NumberUtils.isNumber("0"));
        System.out.println(NumberUtils.toInt("0"));
        System.out.println(NumberUtils.isNumber("1.1"));
        System.out.println(NumberUtils.toInt("1.1"));
        System.out.println(NumberUtils.isNumber(null));
        System.out.println(NumberUtils.isNumber(""));
        System.out.println(NumberUtils.isNumber(""));
        System.out.println(NumberUtils.isNumber(" "));

        System.out.println("-------------------->");

        System.out.println(NumberUtils.isDigits("40"));
        System.out.println(NumberUtils.isDigits("-40"));
        System.out.println(NumberUtils.isDigits("-0"));
        System.out.println(NumberUtils.isDigits("0"));
        System.out.println(NumberUtils.isDigits("0.1"));
        System.out.println(NumberUtils.isDigits(null));
        System.out.println(NumberUtils.isDigits(""));
        System.out.println(NumberUtils.isDigits(""));
        System.out.println(NumberUtils.isDigits(" "));


        Integer m = 998;
        System.out.println(Long.valueOf(m));
        System.out.println(998L);
        System.out.println(m == 998);
        System.out.println(StringUtils.isNumeric("-40"));
    }
}
