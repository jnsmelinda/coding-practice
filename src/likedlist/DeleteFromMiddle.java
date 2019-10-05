package likedlist;

public class DeleteFromMiddle {
    private static void deleteFromMiddle(ListNode node) {
        if (node != null || node.next != null) {
            node.data = node.next.data;
            node.next = node.next.next;
        }
    }

    private static void remove(LinkedList list, ListNode node) {
        if (list.head != null) {
            ListNode current = list.head;
            while (current.next != null) {
                if (current.data == node.data) {
                    deleteFromMiddle(current);
                }
                current = current.next;
            }
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        int[] arr = {1,4,2,5,1,2,6,1};
        for (int element : arr) {
            list.addToTail(element);
        }
        System.out.println(list);
        ListNode node = new ListNode(1);
        remove(list, node);
        System.out.println(list);
    }
}
