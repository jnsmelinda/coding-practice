package leetcode.p019_remove_nth_node_from_end_ofList;

public class RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(5);
        ListNode node1 = new ListNode(6);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(7);
        ListNode node4 = new ListNode(8);
        list1.next = node1;
        list1.next.next = node2;
        list1.next.next.next = node3;
        list1.next.next.next.next = node4;
        System.out.println(list1);
        System.out.println(removeNthFromEnd(list1, 2));
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 1;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }

        ListNode newCurrent = new ListNode(0, head);
        ListNode result = newCurrent;
        int counter = 1;
        while (newCurrent != null) {
            if (counter == length - n) {
                ListNode temp = newCurrent.next.next;
                newCurrent.next.next = null;
                newCurrent.next = temp;
            }

            newCurrent = newCurrent.next;
            counter++;
        }

        return result.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public String toString() {
            return val + " -> " + next;
        }
    }
}
