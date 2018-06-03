package com.interview.stack;

/**
 * 用栈来求解汉诺塔问题
 * <p>
 * 题目：
 * 汉诺塔问题比较经典，这里修改一下游戏规则：现在限制不能从最左侧的塔直接移动
 * 到最右侧，也不能从最右侧直接移动到最左侧，而是必须经过中间。求当塔有～层的时候，
 * 打印最优移动过程和最优移动总步数。
 * <p>
 * 例如，当塔数为两层时，最上层的塔记为1，最下层的塔记为2，则打印：
 * Move l from left to mid
 * Move l from mid to right
 * Move 2 from left to mid
 * Move l from right to mid
 * Move l from mid to left
 * Move 2 from mid to right
 * Move l from left to mid
 * It will move  8 steps.
 * <p>
 * 注意：关于汉诺塔游戏的更多讨论，将在本书递归与动态规划的章节中继续。
 * 【要求】
 * 用以下两种方法解决
 * 方法一：递归的方法；
 * 方法二：非递归的方法，用栈来模拟汉诺塔的三个塔。
 * 【难度】校★★★☆
 */
public class Hanoi {
    public int hanoiProbleml(int num, String left, String mid, String right) {
        if (num < 1) {
            return 0;
        }
        return process(num, left, mid, right, left, right);
    }

    public int process(int num, String left, String mid, String right, String from, String to) {
        if (num == 1) {
            if (from.equals(mid) || to.equals(mid)) {
                System.out.println("Move  l  from  " + from + " to " + to);
                return 1;
            } else {
                System.out.println("Move  l  from  " + from + " to " + mid);
                System.out.println("Move  l  from  " + mid + " to " + to);
                return 2;
            }
        }

        if (from.equals(mid) || to.equals(mid)) {
            String another = (from.equals(left) || to.equals(left)) ? right : left;
            int partl = process(num - 1, left, mid, right, from, another);
            int part2 = 1;
            System.out.println("Move  " + num + " from  " + from + " to " + to);
            int part3 = process(num - 1, left, mid, right, another, to);
            return partl + part2 + part3;
        } else {
            int partl = process(num - 1, left, mid, right, from, to);
            int part2 = 1;
            System.out.println("Move  " + num + " from  " + from + " to " + mid);
            int part3 = process(num - 1, left, mid, right, to, from);
            int part4 = 1;
            System.out.println("Move  " + num + " from  " + mid + " to " + to);
            int part5 = process(num - 1, left, mid, right, from, to);
            return partl + part2 + part3 + part4 + part5;
        }
    }

    public int hanoiProblem2 (int num,  String left,  String mid, String right)  {
        //TODO
        return 0;
    }
}

enum Action {
    No,  LToM, MToL, MToR, RToM
}
