package likedlist;

public class LinkedList {
    public ListNode head;

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
