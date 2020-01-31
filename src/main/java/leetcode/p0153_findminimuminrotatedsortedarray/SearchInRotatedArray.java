package leetcode.p0153_findminimuminrotatedsortedarray;

public class SearchInRotatedArray {
    public static void main(String[] args) {
        int[] arr = {15, 16, 20, 25, 27, 30, 1, 2, 4, 10, 11};
        System.out.println(findLowest(arr));
    }

    public static int findLowest(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
}
