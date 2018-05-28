package com.interview.stack;

import java.util.Stack;

public class MyStack1 {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MyStack1(){
        this.stackData = new Stack<>();
        this.stackMin = new Stack<>();
    }
}
