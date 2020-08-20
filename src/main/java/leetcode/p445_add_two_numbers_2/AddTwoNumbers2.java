package leetcode.p445_add_two_numbers_2;
import java.util.Stack;

public class AddTwoNumbers2 {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(5);
        ListNode list2 = new ListNode(8);

        ListNode node1 = new ListNode(6);
        ListNode node2 = new ListNode(4);
        ListNode node4 = new ListNode(4);

        list1.next = node1;
        list1.next.next = node2;

        list2.next = node4;

        System.out.println(addTwoNumbers(list1, list2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack();
        Stack<Integer> stack2 = new Stack();

        ListNode result = null;
        ListNode current1 = l1;
        ListNode current2 = l2;

        int sizeDiff = size(l1) - size(l2);

        if (size(l1) > size(l2)) {
            while (sizeDiff > 0) {
                ListNode node = new ListNode(0);
                node.next = current2;
                current2 = node;
                sizeDiff--;
            }
        }
        else if (size(l2) > size(l1)) {
            while (sizeDiff < 0) {
                ListNode node = new ListNode(0);
                node.next = current1;
                current1 = node;
                sizeDiff++;
            }
        }

        while (current1 != null || current2 != null) {

            if (current1 != null) {
                stack1.push(current1.val);
            }
            if (current2 != null) {
                stack2.push(current2.val);
            }

            if (current1 != null) {
                current1 = current1.next;
            }

            if (current2 != null) {
                current2 = current2.next;
            }
        }

        int remainder = 0;
        int pop1 = 0;
        int pop2 = 0;

        int temp = 0;
        int data = 0;

        remainder = 0;
        while(!stack1.empty() || !stack2.empty() || remainder > 0) {

            if (stack1.empty() && stack2.empty()) {
                pop1 = 0;
                pop2 = 0;
            }
            else {
                pop1 = stack1.pop();
                pop2 = stack2.pop();
            }
            temp = pop1 + pop2 + remainder;
            data = temp % 10;

            remainder = temp / 10;

            if (result == null) {
                result = new ListNode(data);
            }
            else {
                ListNode newHead = new ListNode(data);
                newHead.next = result;
                result = newHead;
            }
        }

        return result;
    }

    public static int size(ListNode list) {
        int size = 0;

        while (list != null) {
            size++;
            list = list.next;
        }
        return size;
    }

    public static class ListNode {
        int val;
        AddTwoNumbers2.ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, AddTwoNumbers2.ListNode next) { this.val = val; this.next = next; }

        public String toString() {
            return val + " -> " + next;
        }
    }
}
