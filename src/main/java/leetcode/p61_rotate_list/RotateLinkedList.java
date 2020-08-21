package leetcode.p61_rotate_list;
public class RotateLinkedList {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(5);
        ListNode node1 = new ListNode(6);
        ListNode node2 = new ListNode(4);
        list1.next = node1;
        list1.next.next = node2;
        System.out.println(rotateRight(list1, 6));
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0 || size(head) == 1 || k == size(head) || k % size(head) == 0) {
            return head;
        }
        ListNode newTail = null;
        int barrier = size(head) - (k % size(head));

        ListNode current = head;
        int counter = 1;
        while (counter <= barrier) {
            if (newTail == null){
                newTail = new ListNode(current.val);
            }
            else {
                ListNode temp = newTail;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = new ListNode(current.val);
            }
            counter++;
            current = current.next;
        }

        ListNode temp = current;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = newTail;

        return current;
    }

    public static int size(ListNode list) {
        int size = 0;

        while (list != null) {
            size++;
            list = list.next;
        }
        return size;
    }

    public static class ListNode { int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        public String toString() {
            return val + " -> " + next;
        }
    }
}
