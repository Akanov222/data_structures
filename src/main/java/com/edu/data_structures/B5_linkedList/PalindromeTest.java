package com.edu.data_structures.B5_linkedList;

public class PalindromeTest {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(12);
        ListNode node4 = new ListNode(10);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;


        printNode(node1);
        System.out.println(isPalindrome(node1));
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // 1. Находим середину списка
        ListNode slow = head;
        ListNode fast = head;

        // 2. Разворачиваем вторую половину
        ListNode secondHalf = reversList(head);
        ListNode firstHalf = head;

        // 3. Сравниваем две половины
        ListNode temp = secondHalf;
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        // 4. (Опционально) Восстанавливаем исходный список
        reversList(temp);

        return true;
    }

    public static ListNode reversList(ListNode head) {
        ListNode preview = null;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next;
            preview = current;
            current = next;
        }

        return preview;
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