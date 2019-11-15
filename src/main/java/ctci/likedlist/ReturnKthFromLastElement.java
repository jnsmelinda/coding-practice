package ctci.likedlist;

public class ReturnKthFromLastElement {
    public static int returnKthFromLastElement(LinkedList list, int k) {
        ListNode current1 = list.head;
        ListNode current2 = list.head;

        if (list.head != null) {
            for (int i = 0; i < k - 1; i++) {
                if (current1 == null) {
                    System.out.println("out of bounds");
                }
                current1 = current1.next;
            }

            while (current1.next != null) {
                current1 = current1.next;
                current2 = current2.next;
            }
        }

        return current2.data;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        int[] arr = {1,4,2,5,1,2,6,1};
        for (int element : arr) {
            list.addToTail(element);
        }
        System.out.println(list);
        System.out.println(returnKthFromLastElement(list, 4));
    }
}
