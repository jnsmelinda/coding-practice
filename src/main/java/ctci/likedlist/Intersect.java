package ctci.likedlist;

public class Intersect {

    public static ListNode getIntersection(LinkedList list1, LinkedList list2) {
        if (list1.getLast(list1.head) != list2.getLast(list2.head)) {
            System.out.println("not intersecting");
        }

        LinkedList biggerList = list1.size > list2.size ? list1 : list2;
        LinkedList smallerList = list1.size > list2.size ? list2 : list1;

        int difference = biggerList.size - smallerList.size;

        int counter = 0;
        ListNode currentBigger = biggerList.head;
        ListNode currentSmaller = smallerList.head;

        return findIntersectingNode(getToEqualSizeNode(difference, counter, currentBigger), currentSmaller);
    }

    private static ListNode getToEqualSizeNode(int difference, int counter, ListNode currentBigger) {
        while (counter < difference) {
            counter++;
            currentBigger = currentBigger.next;
        }
        return currentBigger;
    }

    private static ListNode findIntersectingNode(ListNode currentBigger, ListNode currentSmaller) {
        while (currentBigger != currentSmaller) {
            currentBigger = currentBigger.next;
            currentSmaller = currentSmaller.next;
        }
        return currentBigger;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,4,2,8,0,4,2,1};
        LinkedList list1 = new LinkedList();
        list1.makeTheList(arr1);
        System.out.println("list1: " + list1);
        int[] arr2 = {8,3,6,0,7,3,4,5,8};
        LinkedList list2 = new LinkedList();
        list2.makeTheList(arr2);
        System.out.println("list2: " + list2);
        System.out.println();

        list1.makeIntersection(list2, 2);
        System.out.println("newlist1: " + list1);
        System.out.println("newlist2: " + list2);

        System.out.println(getIntersection(list1, list2));
    }
}
