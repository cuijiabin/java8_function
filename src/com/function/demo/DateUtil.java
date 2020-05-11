package com.function.demo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtil {

    /**
     * 切割时间段
     *
     * @param dateType 交易类型 M/D/H/N -->每月/每天/每小時/每分鐘
     * @param start    yyyy-MM-dd HH:mm:ss
     * @param end      yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static List<String> cutDate(String dateType, String start, String end) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date dBegin = sdf.parse(start);
            Date dEnd = sdf.parse(end);
            return findDates(dateType, dBegin, dEnd);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static List<String> findDates(String dateType, Date dBegin, Date dEnd) throws Exception {
        List<String> listDate = new ArrayList<>();
        Calendar calBegin = Calendar.getInstance();
        calBegin.setTime(dBegin);
        Calendar calEnd = Calendar.getInstance();
        calEnd.setTime(dEnd);
        while (calEnd.after(calBegin)) {
            switch (dateType) {
                case "M":
                    calBegin.add(Calendar.MONTH, 1);
                    break;
                case "D":
                    calBegin.add(Calendar.DAY_OF_YEAR, 1);
                    break;
                case "H":
                    calBegin.add(Calendar.HOUR, 1);
                    break;
                case "N":
                    calBegin.add(Calendar.SECOND, 1);
                    break;
            }
            if (calEnd.after(calBegin))
                listDate.add(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calBegin.getTime()));
            else
                listDate.add(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calEnd.getTime()));
        }
        return listDate;
    }

    public static int getAge(Date dateOfBirth) {
        int age = 0;
        Calendar born = Calendar.getInstance();
        Calendar now = Calendar.getInstance();
        if (dateOfBirth != null) {
            now.setTime(new Date());
            born.setTime(dateOfBirth);
            if (born.after(now)) {
                throw new IllegalArgumentException("年龄不能超过当前日期");
            }
            age = now.get(Calendar.YEAR) - born.get(Calendar.YEAR);
            int nowDayOfYear = now.get(Calendar.DAY_OF_YEAR);
            int bornDayOfYear = born.get(Calendar.DAY_OF_YEAR);
            System.out.println("nowDayOfYear:" + nowDayOfYear + " bornDayOfYear:" + bornDayOfYear);
            if (nowDayOfYear < bornDayOfYear) {
                age -= 1;
            }
        }
        return age;
    }

    // 根据年月日计算年龄,birthTimeString:"1994-11-14"
    public static String getAgeFromBirthTime(int yearBirth, int monthBirth, int dayOfMonthBirth) {
        // 得到当前时间的年、月、日
        Calendar cal = Calendar.getInstance();
        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH) + 1;
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);

        int age = (yearNow - yearBirth);

        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                if (dayOfMonthNow < dayOfMonthBirth) {
                    age--;
                }
            } else {
                age--;
            }
        }

        if (age > 0) {
            return age + "岁";
        }

        int month = (monthNow - monthBirth);
        if (yearNow - yearBirth > 0) {
            month += 12;
        }
        if (dayOfMonthNow < dayOfMonthBirth) {
            month--;
        }

        // 不足一个月 按照一个月计算
        if (month == 0) {
            month = 1;
        }

        return month + "个月";
    }


    public static void main(String[] args) {
//        String start = "2016-02-01 00:00:00";
//        String end = "2016-02-01 23:59:01";
//        List<String> list = DateUtil.cutDate("H", start, end);
//        for (String str : list) {
//            System.out.println(str);
//        }

        System.out.println(getAgeFromBirthTime(2019, 3, 18));

        System.out.println(String.valueOf(2029).substring(2,3));
//        System.out.println(DateUtil.parseDate(basicBirthday, "yyyy-MM-dd").before(new Date()));
    }

}
