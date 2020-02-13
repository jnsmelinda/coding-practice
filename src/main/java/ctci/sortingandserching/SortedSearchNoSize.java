package ctci.sortingandserching;

public class SortedSearchNoSize {
    public static void main(String[] args) {
        int[] arr = {1,3,6,8,9,10,15,18,24,25,29,32,35,37,40};
        System.out.println(sortedSearchNoSize(arr, 29));
    }

    //No array.length method allowed to use.

    public static int sortedSearchNoSize(int[] arr, int value) {
        if (arr[0] == value) {
            return 0;
        }

        int index = 1;
        while (return_1(arr, index) != -1 && return_1(arr, index) < value) {
            index *= 2;
        }
        return binary(arr, index / 2, index, ((index / 2) + index - 1) / 2, value);
    }

    private static int binary(int[] arr, int begin, int end, int mid, int value) {
        if (arr[mid] == value) {
            return mid;
        }
        else if (arr[mid] < value || return_1(arr, mid) == -1) {
            binary(arr, mid + 1, end, (mid + 1 + end) / 2, value);
        }
        else if (arr[mid] > value || return_1(arr, mid) == -1) {
            binary(arr, mid, mid - 1, (mid + mid - 1) / 2, value);
        }

        return -1;
    }

    private static int return_1(int[] arr, int index) {
        if (index > arr.length) {
            return -1;
        }
        else return arr[index];
    }

}
