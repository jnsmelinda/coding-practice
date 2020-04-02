package leetcode.p430_flatten_multilevel_doubly_linked_list;

public class FlattenMultilevelDoublyLinkedList {
    public static void main(String[] args) {

    }
    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }

        Node current = head;
        flat(current);
        return head;
    }

    public static Node flat(Node current) {
        while(current.next != null || current.child !=null) {
            if(current.child == null) {
                current = current.next;
            } else {
                Node t = flat(current.child);
                if(current.next != null) {
                    current.next.prev = t;
                    t.next = current.next;
                }
                current.next = current.child;
                current.child.prev = current;
                current.child = null;
            }
        }

        return current;
    }
}

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
}
