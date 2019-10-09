package likedlist;

public class LinkedList {
    public ListNode head;
    public int size;

    public void addToTail(int data) {
        if (head == null){
            head = new ListNode(data);
        }
        else {
            ListNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new ListNode(data);
        }
        size++;
    }

    public void addToFront(int data) {
        if (head == null) {
            head = new ListNode(data);
        }
        else {
            ListNode newHead = new ListNode(data);
            newHead.next = head;
            head = newHead;
        }
        size++;
    }

    @Override
    public String toString() {
        if (head == null){
            return null;
        }
        else {
            return head.toString();
        }
    }
}
