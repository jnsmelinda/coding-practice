package ctci.sortingandserching;

import java.util.Arrays;
import java.util.Collections;

import static java.util.Arrays.*;

public class SparseSearch {
    public static void main(String[] args) {
        String[] arr = {"cat", "", "", "", "ball", "", "", "abd", "", ""};
        System.out.println(Arrays.toString(arr));
        System.out.println(findIndex(arr, "ball", 0, arr.length));
    }

    public static int findIndex(String[] arr, String word) {
        if (word == null || arr == null || word == "") {
            return -1;
        }
        return findIndex(arr, word, 0, arr.length);
    }

    private static int findIndex(String[] arr, String word, int first, int last) {
        if (first > last) {
            return -1;
        }
        int mid = (first + last) / 2;
        if (arr[mid].isEmpty()) {
            int left = mid - 1;
            int right = mid - 1;
            while (true) {
                if (left < first && right > last) {
                    return -1;
                }
                else if (right <= last && !arr[right].isEmpty()) {
                    mid = right;
                    break;
                } else if (left >= first && !arr[left].isEmpty()) {
                    mid = left;
                    break;
                }
                right++;
                left--;
            }
        }

        if (word.equalsIgnoreCase(arr[mid])) {
            return mid;
        }
        else if (arr[mid].compareTo(word) < 0) {
            return findIndex(arr, word, mid + 1, last);
        }
        else {
            return findIndex(arr, word, first, mid -1);
        }
    }
}
