package com.thread.chapter03;

import java.util.Date;

public class Tools {
    public static ThreadLocal<Date> tl = new ThreadLocal<>();
}
