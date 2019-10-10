package likedlist;

public class LoopDetection {
    public static ListNode loopDetector(LinkedList list) {
        ListNode slower = list.head;
        ListNode faster = list.head;

        while (faster != null && faster.next != null) {
            slower = slower.next;
            faster = faster.next.next;
            if (slower == faster) {
                break;
            }
        }

        if (faster == null || faster.next == null) {
            return null;
        }

        slower = list.head;
        while (slower != faster) {
            slower = slower.next;
            faster = faster.next;
        }

        return faster;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5,6,7,8,9,0};
        LinkedList list1 = new LinkedList();
        list1.makeTheList(arr1);
        System.out.println("list1: " + list1);
        list1.makeLoop(5);
        System.out.println(list1.size);
        list1.printLoop();

        ListNode detected = loopDetector(list1);
        System.out.println(detected.data);
    }
}
