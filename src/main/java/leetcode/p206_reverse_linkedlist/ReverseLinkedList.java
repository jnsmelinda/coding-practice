package leetcode.p206_reverse_linkedlist;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(5);
        ListNode node1 = new ListNode(6);
        ListNode node2 = new ListNode(4);
        list1.next = node1;
        list1.next.next = node2;
        System.out.println(reverseList(list1));
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head=prev;

        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
        public String toString() {
            return val + " -> " + next;
        }
    }
}
