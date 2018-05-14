/**
 * Copyright © 2016智互联. All rights reserved.
 *
 * @Title: Solution.java
 * @Prject: function-java
 * @Package: com.function.chapter01
 * @Description: TODO
 * @author: cuijiabin
 * @date: 2016年10月11日 下午7:18:29
 */
package com.function.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Solution {

    public boolean wordBreak(String s, Set<String> wordDict) {
        // 参数校验
        if (s == null || s.length() < 1 || wordDict == null || wordDict.size() < 1) {
            return false;
        }

        // 标记是否匹配，match[i]表示 str[0, i-1]可以分割
        int length = s.length();
        boolean[] match = new boolean[length + 1];
        match[0] = true;

        for (int i = 1; i < length + 1; i++) {
            for (int j = 0; j < i; j++) {
                if (match[j] && wordDict.contains(s.substring(j, i))) {
                    // s(0,n) = s(0,i) + s(i,j) + s(j,n)
                    match[i] = true;
                    break;
                }
            }
        }
        System.out.println(match);
        return match[length];
    }

    public void ssss(String s) {
        int length = s.length();
        int index = 0;
        for (int i = 0; i < 4; i++) {

            for (int j = index; j < length; j++) {
                if (j > index) {
                    String t = s.substring(index, j);
                    if (Integer.parseInt(t) > 255) {
                        return;
                    } else {
                        index = j;
                        System.out.println(t);
                        continue;
                    }

                }
            }
        }

        return;
    }

    public static int F(int m, int n) {
        if (m == 0 || m == 1) return 1;
        if (n == 0 || n == 1) return 1;
        if (m < n) {
            return F(m, m);
        } else {
            return F(m - n, n) + F(m, n - 1);
        }
    }

    ;

    public static List<List<String>> s1(String str) {
        List<List<String>> list = new ArrayList<List<String>>();
        for (int i = 1; i < str.length(); i++) {
            list.add(Arrays.asList(str.substring(0, i), str.substring(i)));
        }
        return list;
    }

    public static List<List<String>> s2(String lastStr) {

        List<List<String>> list = new ArrayList<List<String>>();

        List<List<String>> spliArr = s1(lastStr);
        for (List<String> m : spliArr) {
            String first = m.get(0);
            String next = m.get(1);

            List<List<String>> subl = s1(next);

            for (List<String> s : subl) {
                List<String> newS = new ArrayList<String>();
                newS.add(first);
                newS.addAll(s);
                list.add(newS);
            }


        }

        for (List<String> m : list) {
            System.out.println(m.toString());
        }
        return list;
    }

    public static List<List<String>> scal(List<List<String>> array, int num) {

        if (num == 1) return array;
        List<List<String>> list = new ArrayList<List<String>>();
        for (List<String> m : array) {
            List<String> leftArr = m.subList(0, m.size() - 1);
            String next = m.get(m.size() - 1);

            List<List<String>> sublist = s1(next);

            for (List<String> s : sublist) {
                List<String> newS = new ArrayList<String>();
                newS.addAll(leftArr);
                newS.addAll(s);
                list.add(newS);
            }


        }

        return scal(list, num - 1);
    }

    public static void main(String[] args) {
        List<List<String>> list = new ArrayList<List<String>>();
        list.add(Arrays.asList("2502501135"));
        List<List<String>> ll = scal(list, 4);
        for (List<String> m : ll) {
            System.out.println(m.toString());
        }
        ;
    }

}