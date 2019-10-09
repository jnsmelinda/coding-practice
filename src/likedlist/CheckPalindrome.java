package likedlist;

import java.util.Stack;

public class CheckPalindrome {

    private static boolean checkPalindrome(LinkedList list) {
        if (list.head == null) {
            System.out.println("empty list");
        }
        else {
            Stack stack = new Stack();
            ListNode current = getToTheMiddleOfList(list, stack);

            if (StackPopCheck(list, stack)) return false;

            return compareStackAndNode(stack, current);
        }
        return false;
    }

    private static ListNode getToTheMiddleOfList(LinkedList list, Stack stack) {
        ListNode current = list.head;
        int index = 0;
        while (index <= list.size / 2) {
            stack.push(current.data);
            index++;
            current = current.next;
        }
        return current;
    }

    private static boolean StackPopCheck(LinkedList list, Stack stack) {
        if (list.size % 2 != 0) {
            stack.pop();
        }
        else {
            if ((int)stack.pop() != (int)stack.pop()) {
                return true;
            }
        }
        return false;
    }

    private static boolean compareStackAndNode(Stack stack, ListNode current) {
        while (current != null) {
            if (current.data != (int)stack.pop()){
                return false;
            }
            current = current.next;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,2,0,1,0};
        LinkedList list = new LinkedList();
        for (int element : arr) {
            list.addToTail(element);
        }
        System.out.println(list.size);
        System.out.println(checkPalindrome(list));
    }
}
