package likedlist;

public class SumLists {

    public static LinkedList sumLists(LinkedList list1, LinkedList list2) {
        int sum = compose(list1.head) + compose(list2.head);
        System.out.println(sum);
        LinkedList result = new LinkedList();

        while (sum > 0) {
            result.addToTail(sum % 10);
            sum = sum / 10;
        }

        return result;
    }

    public static int compose(ListNode current) {
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

    private static LinkedList makeList(int[] arr) {
        LinkedList result = new LinkedList();
        for (int element : arr) {
            result.addToTail(element);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {7,1,6};
        int[] arr2 = {5,9,2};
        LinkedList linkedList1 = makeList(arr1);
        LinkedList linkedList2 = makeList(arr2);
        System.out.println(sumLists(linkedList1, linkedList2));
    }
}
