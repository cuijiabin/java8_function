package com.interview.stack;

import java.util.LinkedList;

/**
 * 生成窗口最大值数组
 * 【题目】
 * 有一个整型数组arr和一个大小为w的窗口从数组的最左边滑到最右边，窗口每次向
 * 右边滑一个位置。
 * 例如，数组为[4,3，5，4，3,3，6，7]，窗口大小为3时：
 * [4  3  5]4  3  3  6  7    窗口中最大值为5
 * 4  [3  5  4)3  3  6  7  窗口中最大值为5
 * 4  3[s  4  313  6  7    窗口中最大值为5
 * 4  3  5[4  3  3167  窗口中最大值为4
 * 4  3  5  4  [3  3  617    窗口中最大值为6
 * 4  3  5  4  3  [3  6  71    窗口中最大值为7
 *
 * 如果数组长度为n，窗口大小为w，则一共产生n-w+l个窗口的最大值。
 * 请实现一个函数。
 * 输入：整型数组arr，窗口大小为w。
 * 输出：一个长度为n-w+l的数组res，res[i]表示每一种窗口状态下的最大值。
 * 以本题为例，结果应该返回{5,5，5，4，6,7}.
 */
public class GenWinMaxArr {
    public int[] getMaxWindow(int[] arr, int w) {

        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }

        LinkedList<Integer> qmax = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {
                qmax.pollLast();
            }
            qmax.addLast(i);
            if (qmax.peekFirst() == i - w) {
                qmax.pollFirst();
            }
            if (i >= w - 1) {
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }
}
