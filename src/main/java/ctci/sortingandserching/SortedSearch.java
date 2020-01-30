package ctci.sortingandserching;

import java.util.Arrays;

public class SortedSearch {
    public static void main(String[] args) {
        int[] arrA = new int[10];
        arrA[0] = 3;
        arrA[1] = 4;
        arrA[2] = 7;
        arrA[3] = 8;
        arrA[4] = 10;

        int[] arrB = {0,1,5,9,11};
        merge(arrA, arrB, 4);
        System.out.println(Arrays.toString(arrA));
    }

    public static void merge(int[] arrA, int[] arrB, int i){
        int j = arrB.length - 1;
        int capacity = arrA.length - 1;

        while (j >= 0) {
            if (i >= 0 && arrA[i] >= arrB[j]) {
                arrA[capacity] = arrA[i];
                i--;
            } else {
                arrA[capacity] = arrB[j];
                j--;
            }
            capacity--;
        }
    }
}
