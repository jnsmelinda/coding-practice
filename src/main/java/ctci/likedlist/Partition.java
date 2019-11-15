package ctci.likedlist;

public class Partition {
    private static LinkedList partition(LinkedList list, int x) {
        LinkedList higherThanX = new LinkedList();
        LinkedList result = new LinkedList();
        if (list != null) {
            ListNode current = list.head;
            while (current != null) {
                if (current.data < x) {
                    result.addToTail(current.data);
                }
                else if (current.data >= x) {
                    higherThanX.addToTail(current.data);
                }
                current = current.next;
            }
        }

        if (result.head == null) {
            return list;
        } else {
            appendLists(higherThanX, result);
        }

        return result;
    }

    private static void appendLists(LinkedList higherThanX, LinkedList result) {
        ListNode current = getListNode(result);
        current.next = higherThanX.head;
    }

    private static ListNode getListNode(LinkedList lowerThanX) {
        ListNode current = lowerThanX.head;
        while (current.next != null) {
            current = current.next;
        }
        return current;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        int[] arr = {4,6,5,2,3,7,1,0,8};
        list.makeTheList(arr);
        System.out.println(list);
        System.out.println(partition(list, 5));
    }
}

