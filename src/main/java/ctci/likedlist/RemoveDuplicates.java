package ctci.likedlist;

public class RemoveDuplicates {

    public static void removeDuplicates(LinkedList list){
        if (list.head == null) {
            System.out.println("empty list");
        }
        else {
            ListNode current = list.head;
            while (current.next != null) {
                ListNode runner = current;
                while (runner.next != null) {
                    if (runner.next.data == current.data) {
                        runner.next = runner.next.next;
                    }else {
                        runner = runner.next;
                    }
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
        removeDuplicates(list);
        System.out.println(list);
    }
}
