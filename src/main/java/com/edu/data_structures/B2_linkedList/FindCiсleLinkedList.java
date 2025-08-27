package com.edu.data_structures.B2_linkedList;

public class FindCiсleLinkedList {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(7);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node2);

        System.out.println(hasCicle(node1));
    }

    public static boolean hasCicle(ListNode head) {
        if (head == null || head.getNext() == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
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
Определить, содержит ли односвязный список цикл (когда какой-то элемент ссылается на предыдущий)

Алгоритм Флойда:
Медленный указатель двигается на 1 шаг, быстрый - на 2
Если есть цикл, они обязательно встретятся
Если быстрый указатель достиг null - цикла нет
Сложность: O(n), Память: O(1)
*/
