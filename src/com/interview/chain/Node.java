package com.interview.chain;

/**
 * 打印两个有序链表的公共部分
 * <p>
 * 【题目】
 * 给定两个有序链表的头指针headl和head2，打印两个链表的公共部分。
 * 【难度】士★☆☆☆
 */
public class Node {
    public int value;
    public Node next;

    public Node(int data) {
        this.value = data;
    }

    public static void printCommonPart(Node head1, Node head2) {
        System.out.print("Common  Part: ");
        while (head1 != null && head2 != null) {
            if (head1.value < head2.value) {
                head1 = head1.next;
            } else if (head1.value > head2.value) {
                head2 = head2.next;
            } else {
                System.out.print(head1.value + " ");
                head1 = head1.next;
                head2 = head2.next;
            }
        }
        System.out.println("end");
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;

        printCommonPart(n1, n4);
    }
}
