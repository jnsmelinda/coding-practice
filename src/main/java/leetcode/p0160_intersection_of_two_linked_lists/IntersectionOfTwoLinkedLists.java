package leetcode.p0160_intersection_of_two_linked_lists;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {
        ListNode node = new ListNode(4);
        node.next = new ListNode(1);
        node.next.next = new ListNode(8);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);

        ListNode node2 = new ListNode(5);
        node2.next = new ListNode(0);
        node2.next.next = new ListNode(1);
        node2.next.next.next = node.next.next;

        System.out.println(node.toString());
        System.out.println(node2.toString());

        System.out.println(getIntersectionNode(node, node2));
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> visited = new HashSet<>();

        while (headA != null) {
            visited.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (visited.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }

        return null;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
          val = x;
          next = null;
        }

        public String toString() { return val + " -> " + next; }
    }
}
