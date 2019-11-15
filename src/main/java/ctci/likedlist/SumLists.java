package ctci.likedlist;

public class SumLists {

    public static LinkedList sumLists1(LinkedList list1, LinkedList list2) {
        int sum = compose1(list1.head) + compose1(list2.head);
        return deCompose1(sum, new LinkedList());
    }

    private static LinkedList deCompose1(int sum, LinkedList result) {
        while (sum > 0) {
            result.addToTail(sum % 10);
            sum = sum / 10;
        }
        return result;
    }

    public static int compose1(ListNode current) {
        int sum = 0;
        if (current != null) {
            int digit = 1;
            while (current != null) {
                sum += current.data * digit;
                digit *= 10;
                current = current.next;
            }
        }

        return sum;
    }

    public static LinkedList sumLists2(LinkedList list1, LinkedList list2) {
        int sum = (compose2(list1.head, list1.size)) + (compose2(list2.head, list2.size));
        return deCompose2(sum, new LinkedList());
    }

    public static int compose2(ListNode current, double digit) {
        int sum = 0;
        digit = Math.pow(10, digit);
        while (current != null) {
            sum += current.data * digit;
            digit /= 10;
            current = current.next;
        }

        return sum;
    }

    private static LinkedList deCompose2(int sum, LinkedList result) {
        while (sum > 0) {
            result.addToFront(sum % 10);
            sum = sum / 10;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {7,1,6};
        int[] arr2 = {5,9,2};
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();
        System.out.println(sumLists1(list1.makeTheList(arr1), list2.makeTheList(arr2)));
        int[] arr3 = {6,1,7};
        int[] arr4 = {2,9,5};
        LinkedList list3 = new LinkedList();
        LinkedList list4 = new LinkedList();
        System.out.println(sumLists1(list3.makeTheList(arr3), list4.makeTheList(arr4)));
    }
}
