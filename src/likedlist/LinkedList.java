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

    public LinkedList makeTheList(int[] arr) {
        for (int element : arr) {
            this.addToTail(element);
        }
        return this;
    }

    public void makeIntersection(LinkedList other, int position) {
        if (position > other.size) {
            System.out.println("position is higher than size");
        }
        if (head == null) {
            System.out.println("empty list");
        }

        else {
            int counter = 1;
            ListNode current = other.head;
            while (counter != position) {
                counter++;
                current = current.next;
            }
            getLast(this.head).next = current.next;
            size += other.size - counter;
        }
    }

    public void makeLoop(int position) {
       int counter = 1;
       ListNode current = this.head;
       while (counter < position) {
           current = current.next;
           counter++;
       }
       ListNode temp = current;
       getLast(current).next = temp;
    }

    public void printLoop(){
        int counter = 1;
        ListNode current = this.head;
        while (counter <= size * 2) {
            System.out.print(current.data + " ");
            current = current.next;
            counter++;
        }
        System.out.println();
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
