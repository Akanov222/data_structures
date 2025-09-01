package com.edu.data_structures.B4_linkedList;

public class MergeTwoSortedLinkedLists {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(12);
        ListNode node4 = new ListNode(10);
        ListNode node5 = new ListNode(21);
        ListNode node6 = new ListNode(22);
        ListNode node7 = new ListNode(58);
        ListNode node8 = new ListNode(80);
        ListNode dummy = new ListNode(0);
        ListNode node9 = dummy;
        node1.next = node5;
        node3.next = node5;
        node5.next = node7;

        node2.next = node4;
        node4.next = node6;
        node6.next = node8;

        printNode(node1);
        System.out.println();
        printNode(node2);
        node9.next = mergeTwoLists(node1, node2);
        System.out.println();
        printNode(node9.next);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        return dummy.next;
    }

    public static void printNode(ListNode head) {
        ListNode cursor = new ListNode(0, head);
        cursor = cursor.next;
        while (cursor != null) {
            System.out.print(cursor.getVal() + " ->");
            cursor = cursor.next;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.next = next;
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }
}

/*
Задача:
Объединение двух отсортированных связных списков

Как работает:
Создаем фиктивный узел для упрощения логики
Идем по обоим спискам, выбирая меньший элемент
Присоединяем его к результирующему списку
Когда один список закончится, присоединяем остаток второго

Сложность: O(n + m), где n и m - длины списков
Память: O(1) - создаем только фиктивный узел
*/