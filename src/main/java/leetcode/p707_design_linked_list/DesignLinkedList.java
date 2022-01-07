package leetcode.p707_design_linked_list;

public class DesignLinkedList {
    public static void main(String[] args) {
        MyLinkedList obj = new MyLinkedList();
        int param_1 = obj.get(1);
        obj.addAtHead(3);
        obj.addAtTail(4);
        obj.addAtIndex(1,2);
        obj.deleteAtIndex(4);
        System.out.println(obj);
    }

    public static class MyLinkedList {

        Node head;

        public MyLinkedList() {
        }

        public int get(int index) {
            if (head == null) {
                return -1;
            }
            else {
                Node current = head;
                int i = 0;
                while (current != null) {
                    if (i == index) {
                        return current.val;
                    }
                    i++;
                    current = current.next;
                }
            }
            return -1;
        }

        public void addAtHead(int val) {
            if (head == null){
                head = new Node(val);
            }
            else {
                Node newHead = new Node(val);
                newHead.next = head;
                head = newHead;
            }
        }

        public void addAtTail(int val) {
            if (head == null){
                head = new Node(val);
            }
            else {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = new Node(val);
            }
        }

        public void addAtIndex(int index, int val) {
            if (head == null && index > 0) {
                return;
            }
            if (head == null) {
                head = new Node();
            }
            if (index == 0) {
                this.addAtHead(val);
            }
            int i = 0;
            Node current = head;
            while (current != null) {
                if (i == index - 1) {
                    Node temp = current.next;
                    Node newNode = new Node(val);
                    current.next = newNode;
                    current.next.next = temp;
                    return;
                }
                i++;
                current = current.next;
            }
        }

        public void deleteAtIndex(int index) {
            if (head == null) {
                return;
            }
            if (index == 0) {
                head = head.next;
            }
            else{
                int i = 0;
                Node current = head;
                while (current != null) {
                    if (i == index - 1) {
                        if (current.next == null){
                            return;
                        }
                        else {
                            current.next = current.next.next;
                            return;
                        }
                    }
                    i++;
                    current = current.next;
                }
            }
        }

        public String toString() {
            if (head == null){
                return null;
            }
            else {
                return head.toString();
            }
        }

        private class Node{
            int val;
            Node next = null;

            public Node() {
                this(0, null);
            }

            public Node(int val) {
                this(val, null);
            }

            public Node(int val, Node next) {
                this.val = val;
                this.next = next;
            }

            public String toString() {
                return val + " -> " + next;
            }
        }
    }
}
