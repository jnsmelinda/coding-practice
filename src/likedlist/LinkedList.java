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

    public void addToLast(LinkedList other) {
        ListNode node = other.head;
        if (head == null) {
            head = node;
        }
        else {
            int counter = 1;
            ListNode current = node;
            while (current.data != 0) {
                counter++;
                current = current.next;
            }
            getLast(this.head).next = current.next;
            size += other.size - counter;
        }
    }

    public ListNode getLast(ListNode current) {
        while (current.next != null) {
            current = current.next;
        }
        return current;
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
