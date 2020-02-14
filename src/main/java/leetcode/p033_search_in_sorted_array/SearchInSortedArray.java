package leetcode.p033_search_in_sorted_array;

public class SearchInSortedArray {
    public static void main(String[] args) {

    }

    public static int search(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
