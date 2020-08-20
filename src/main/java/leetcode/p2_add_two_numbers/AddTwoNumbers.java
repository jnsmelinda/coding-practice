package leetcode.p2_add_two_numbers;

import ctci.likedlist.ListNode;

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(5);
        ListNode list2 = new ListNode(2);

        ListNode node1 = new ListNode(6);
        ListNode node2 = new ListNode(4);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(3);

        list1.next = node1;
        list1.next.next = node2;

        list2.next = node4;
        list2.next.next = node5;

        System.out.println(addTwoNumbers(list1, list2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode current1 = l1;
        ListNode current2 = l2;
        ListNode result = new ListNode();
        ListNode current = result;

        int remainder = 0;
        while (current1 != null || current2 != null) {

            int val1 = 0;
            int val2 = 0;

            if (current1 == null) {
                val1 = 0;
            }
            else {
                val1 = current1.val;
            }
            if (current2 == null) {
                val2 = 0;
            }
            else {
                val2 = current2.val;
            }

            int temp = val1 + val2 + remainder;
            int data = temp % 10;

            remainder = temp / 10;

            current.next = new ListNode(data, null);
            current = current.next;

            if (current1 != null) {
                current1 = current1.next;
            }

            if (current2 != null) {
                current2 = current2.next;
            }
        }

        if (remainder > 0) {
            current.next = new ListNode(remainder);
        }

        result = result.next;

        return result;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        public String toString() {
            return val + " -> " + next;
        }
    }
}
