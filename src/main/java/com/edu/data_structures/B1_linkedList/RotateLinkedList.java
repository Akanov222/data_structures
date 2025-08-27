package com.edu.data_structures.B1_linkedList;

public class RotateLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.setNext(new ListNode(3));
        head.getNext().setNext(new ListNode(4));
        head.getNext().getNext().setNext(new ListNode(7));
        head.getNext().getNext().getNext().setNext(new ListNode(8));
        head.getNext().getNext().getNext().getNext().setNext(new ListNode(12));
        head.getNext().getNext().getNext().getNext().getNext().setNext(new ListNode(17));
        head.getNext().getNext().getNext().getNext().getNext().getNext().setNext(new ListNode(21));

        ListNode reversed = reversList(head);
        printList(reversed);
    }

    private static void printList(ListNode head) {

        while (head != null) {
            System.out.print(head.val + " ->");
            head = head.getNext();
        }
    }

    public static ListNode reversList(ListNode head) {
        ListNode preview = null;
        ListNode current = head;
        while (current != null) {
            ListNode temp = current.getNext();
            current.setNext(preview);
            preview = current;
            current = temp;
// preview, current, current.next
// current, current.next, preview
        }
        return preview;
    }

    public static class ListNode {
        int val;
        private ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.setNext(next);
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

1. Разворот односвязного списка
Как работает:
Идем по списку и меняем направление ссылок
Сложность: O(n), Память: O(1)
Визуализация: 1→2→3→null → null←1 2→3→null → null←1←2 3→null → null←1←2←3
*/

