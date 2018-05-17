package com.thread.chapter03;

import org.junit.Test;

public class Run {

    public static ThreadLocal tl = new ThreadLocal();

    @Test
    public void test(){
        if(tl.get() == null){
            System.out.println("从未放过值");
            tl.set("我的值");
        }
        System.out.println(tl.get());
        System.out.println(tl.get());
    }
}
