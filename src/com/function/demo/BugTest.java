package com.function.demo;

import com.google.gson.Gson;

import java.math.BigDecimal;
import java.util.*;

public class BugTest {

    public static List<Integer> elementList = Arrays.asList(16, 8, 4, 2, 1);

    public static void main(String[] args) {
//        for (int i = 1; i < 32; i++) {
//
//            System.out.println(i + " 拆分 " + getSplitList(i));
//        }

//        String string="aa嘻嘻嘻@，#￥%FFF12345";
//        String string="1978785255   721755936（1）";
//        if (string.indexOf(" ") > -1) {
//            System.out.println("包含空格");
//        }
//        if (string.indexOf("\t") > -1) {
//            System.out.println("包含制表符");
//        }
//        System.out.println(string.replaceAll("[^\\u4e00-\\u9fa5]", ""));
//        System.out.println(string.replaceAll("[^\\u4e00-\\u9fa5]", "").length());
//
//
//        BigDecimal qtyActual = new BigDecimal(0).setScale(2,BigDecimal.ROUND_UP);
//        System.out.println(qtyActual.compareTo(BigDecimal.ZERO));
//
//        qtyActual = new BigDecimal(0);
//        System.out.println(new BigDecimal(0).compareTo(BigDecimal.ZERO));
//
//        qtyActual = new BigDecimal(0);
//        System.out.println(new BigDecimal(0.00).compareTo(BigDecimal.ZERO));

        System.out.println(new Date().after(new Date(122,0,15)));
        System.out.println(new Date().after(new Date(122,0,14)));
        System.out.println(new Date(2022,0,14));
        System.out.println(new Date());

    }


}
