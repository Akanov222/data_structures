package com.edu.data_structures.B3_linkedList;

public class DeleteNthNode {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(7);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        printNode(node1);
        node1 = deleteNthNode(node1, 2);
        System.out.println();
        printNode(node1);
    }

    public static ListNode deleteNthNode(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.setNext(head);

        ListNode fast = dummy;
        ListNode slow = dummy;

        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

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
Удаление N-го узла с конца

Как работает:
Стратегия двух указателей:
Создаем фиктивный узел для обработки edge-cases
Fast уходит на n+1 шагов вперед
Когда fast достигнет конца, slow будет перед удаляемым узлом

Сложность: O(n), Память: O(1)
*/