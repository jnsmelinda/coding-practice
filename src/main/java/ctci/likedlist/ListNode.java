package ctci.likedlist;

public class ListNode {
    public int data;
    public ListNode next = null;

    public ListNode() {
        this(0, null);
    }

    public ListNode(int data) {
        this(data, null);
    }

    public ListNode(int data, ListNode next) {
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString() {
        return data + " -> " + next;
    }
}
