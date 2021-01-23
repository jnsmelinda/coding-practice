package leetcode.p021_merge_two_sorted_lists;

public class MergeTwoSortedLists {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        ListNode l1Next = new ListNode(6);
//        ListNode l1NextNext = new ListNode(6);
        l1.next = l1Next;
//        l1.next.next = l1NextNext;

        ListNode l2 = new ListNode(1);
        ListNode l2Next = new ListNode(3);
        ListNode l2NextNext = new ListNode(4);
        l2.next = l2Next;
        l2.next.next = l2NextNext;

        System.out.println(l1.toString());
        System.out.println(l2.toString());

        System.out.println(mergeTwoLists(l1, l2).toString());
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode current = result;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        if (l1 == null) {
            current.next = l2;
        } else if (l2 == null) {
            current.next = l1;
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
