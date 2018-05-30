package com.interview.stack;

import java.util.Stack;

public class MiniStack {

    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MiniStack() {
        this.stackData = new Stack<>();
        this.stackMin = new Stack<>();
    }

    //压栈
    public void push(int newNum) {
        if (this.stackMin.isEmpty()) {
            this.stackMin.push(newNum);
        } else if (newNum <= this.getMin()) {
            this.stackMin.push(newNum);
        }
        this.stackData.push(newNum);
    }

    //弹栈
    public int pop() {
        if (this.stackData.isEmpty()) {
            throw new RuntimeException("your stack is empty");
        }
        int value = this.stackData.pop();
        if (value == this.getMin()) {
            this.stackMin.pop();
        }
        return value;
    }

    public int getMin() {//取栈顶元素
        if (this.stackMin.isEmpty()) {
            throw new RuntimeException("your stack is empty");
        }
        return this.stackMin.peek();
    }

    public static void main(String[] args) {
//        MiniStack s = new MiniStack();
        MiniStack2 s = new MiniStack2();
        s.push(3);
        System.out.println(s.getMin());
        s.push(4);
        System.out.println(s.getMin());
        s.push(6);
        System.out.println(s.getMin());
        s.push(7);
        System.out.println(s.getMin());
        s.push(1);
        System.out.println(s.pop());
        System.out.println(s.getMin());
    }
}

class MiniStack2 {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MiniStack2() {
        this.stackData = new Stack<>();
        this.stackMin = new Stack<>();
    }

    public void push(int newNum) {
        if (this.stackMin.isEmpty()) {
            this.stackMin.push(newNum);
        } else if (newNum <= this.getMin()) {
            this.stackMin.push(newNum);
        } else this.stackMin.push(this.getMin());

        this.stackData.push(newNum);
    }

    public int pop() {
        if (this.stackMin.isEmpty()) {
            throw new RuntimeException("your stack is empty");
        }
        this.stackMin.pop();
        return this.stackData.pop();
    }

    public int getMin() {
        if (this.stackMin.isEmpty()) {
            throw new RuntimeException("your stack is empty");
        }
        return this.stackMin.peek();
    }
}
