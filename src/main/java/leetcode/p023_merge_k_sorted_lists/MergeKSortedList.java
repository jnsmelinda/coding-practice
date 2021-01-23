package leetcode.p023_merge_k_sorted_lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        ListNode l1Next = new ListNode(2); //
        ListNode l1NextNext = new ListNode(6); l1.next = l1Next;
        l1.next.next = l1NextNext;

        ListNode l2 = new ListNode(7);
        ListNode l2Next = new ListNode(3);
        ListNode l2NextNext = new ListNode(4);
        l2.next = l2Next;
        l2.next.next = l2NextNext;

        ListNode l3 = new ListNode(1);
        ListNode l3Next = new ListNode(8);
        ListNode l3NextNext = new ListNode(9);
        l3.next = l3Next;
        l3.next.next = l3NextNext;

        System.out.println(l1.toString());
        System.out.println(l2.toString());
        System.out.println(l3.toString());

        ListNode[] list = new ListNode[3];
        list[0] = l1;
        list[1] = l2;
        list[2] = l3;

        System.out.println(mergeKLists(list).toString());
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < lists.length; i++) {
            ListNode current = lists[i];
            while (current != null) {
                queue.add(current.val);
                current = current.next;
            }
        }

        ListNode result = new ListNode(0);
        ListNode current = result;
        while (!queue.isEmpty()) {

            current.next = new ListNode(queue.poll());
            current = current.next;
        }

        return result.next;
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
