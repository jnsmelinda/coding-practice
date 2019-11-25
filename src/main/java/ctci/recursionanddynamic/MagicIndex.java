package ctci.recursionanddynamic;

public class MagicIndex {

    public static void main(String[] args) {
        int[] arr = {-2, -1, 2, 0, 5, 7, 8, 10};
        System.out.println(magicIndex(arr));
    }

    public static int magicIndex(int[] arr) {
        return magicIndex(arr, 0, arr.length - 1);
    }

    private static int magicIndex(int[] arr, int start, int end) {
        if (end < start) {
            return -1;
        }
        int middle = (start + end) / 2;
        if (arr[middle] == middle) {
            return middle;
        }
        else if (arr[middle] > middle) {
            return magicIndex(arr, start, middle - 1);
        }
        else{
            return magicIndex(arr, middle + 1, end);
        }
    }
}
