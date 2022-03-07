package com.function.es;

import com.google.common.base.Strings;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: cuijiabin
 * @Date: 2021/9/15 14:16
 */
public class Tm {

    private static String desensitizedAddress(String address) {
        if (!Strings.isNullOrEmpty(address)) {
            return StringUtils.left(address, 3).concat(StringUtils.removeStart(StringUtils.leftPad(StringUtils.right(address, address.length() - 11), StringUtils.length(address), "*"), "***"));
        }
        return address;
    }

    /**
     * 脱敏地址字符串中的数字
     *
     * @param address
     * @return
     */
    public static String addressTM(String address) {
        if (address == null) {
            return "";
        }
        char[] aa = address.toCharArray();
        String newAddr = "";
        String temp = "";
        for (int a = aa.length - 1; a >= 0; a--) {
            if ((int) aa[a] >= '0' && (int) aa[a] <= '9') {
                temp = aa[a] + temp;
            } else {
                if (temp.length() > 0) {
                    int l = 2;
                    newAddr = temp.substring((temp.length() < l ? l : temp.length()) - 1) + newAddr;
                    if (temp.length() - 1 < 1) {
                        newAddr = "*" + newAddr;
                    } else {
                        for (int b = 0; b < temp.length() - 1; b++) {
                            newAddr = "*" + newAddr;
                        }
                    }
                }
                temp = "";
                newAddr = aa[a] + newAddr;
            }
        }
        //武胜路333号1层
        Pattern p = Pattern.compile(".*\\d+.*");
        Matcher m = p.matcher(temp);
        if (m.matches()) {
            if (temp.length() > 1) {
                newAddr = "*" + temp.substring(temp.length() - 1) + newAddr;
                for (int i = 0; i < temp.length() - 2; i++) {
                    newAddr = "*" + newAddr;
                }
            } else {
                newAddr = "*" + newAddr;
            }
        }
        return newAddr;
    }

    /**
     * 替换
     *
     * @param value
     */
    public static void replaceLetter(String value) {
        Pattern p = Pattern.compile("[\\d]");
        Matcher matcher = p.matcher(value);
        String result = matcher.replaceAll("*");
        System.out.println(result);
    }

    public static void main(String[] args) {
        System.out.println(desensitizedAddress("徐家棚街街道福星惠誉时代上城2栋2802"));
        System.out.println(addressTM("徐家棚街街道福星惠誉时代上城2栋2802"));
        System.out.println(addressTM("薛家镇建业路18-1号，常州市洪杰精密弹簧有限公司"));

        replaceLetter("薛家镇建业路18-1号，常州市洪杰精密弹簧有限公司");
    }
}
