package com.function.demo;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang3.StringUtils;
//import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * List 转 map
 */
public class List2Map {


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

    private List<Person> pList = Arrays.asList(new Person(1L, "person1", 1),
            new Person(2L, "person2", 2),
            new Person(3L, "person3", 1),
            new Person(4L, "person4", 2),
            new Person(5L, "person5", 2),
            new Person(6L, "person6", 1));

    @Test
    public void genFieldMap() {

        Map<Long, Person> map = pList.stream().collect(Collectors.toMap(Person::getId, p -> p));
        System.out.println(map);

        List<Person> personList = Arrays.asList(new Person(1L, "person1", 1),
                new Person(2L, "person1", 2),
                new Person(3L, "person2", 1),
                new Person(4L, "person2", 2),
                new Person(5L, "person3", 2),
                new Person(6L, "person3", 1));

        Map<String, Person> nameMap = personList.stream().collect(Collectors.toMap(Person::getName, p -> p, (o, n) -> o));
        System.out.println(nameMap);
    }

    @Test
    public void genFieldMapList() {

        Map<Integer, List<Person>> map = pList.stream().collect(Collectors.groupingBy(Person::getSex));
        System.out.println(map.size());
        System.out.println(map.values().size());
        System.out.println(map.values());

        Map<Integer, String> strMap = map.entrySet().stream().collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue().stream().map(Person::getName).collect(Collectors.joining("&"))));
        System.out.println(strMap);
        //map.entrySet().stream().map(e -> e.getKey(), e ->e.getValue().stream().map(Person::getName).collect(Collectors.joining(";")).collect(Collectors.joining(";"));

        Optional<Person> po = pList.stream().filter(p -> p.getId() > 7).sorted((p1, p2) -> p2.getId().compareTo(p1.getId())).findFirst();
        System.out.println(po.isPresent());

        Collections.sort(pList, (x, y) -> x.getSex() - y.getSex());
        pList.forEach(System.out::println);

        Integer m = 998;
        System.out.println(Long.valueOf(m));
        System.out.println(998L);
        System.out.println(m == 998);
        System.out.println(StringUtils.isNumeric("-40"));

        Map<Integer, Long> numMap = pList.stream().collect(Collectors.groupingBy(i -> i.getSex(), Collectors.counting()));
        System.out.println(numMap);

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

    }
}
