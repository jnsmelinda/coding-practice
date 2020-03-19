package ctci.sortingandserching;

import java.util.Arrays;

public class PeaksAndValleys {
    public static void main(String[] args) {
        int[] arr= {1,2,3,4,5,6,7,8,9};
        int[] arr2 = {5,3,1,2,3, 0};
        toPeaksAndValleys1(arr2);
        System.out.println(Arrays.toString(arr2));
    }

//  suboptimal solution
    public static void toPeaksAndValleys1(int[] arr) {
        Arrays.sort(arr);

        int start = 0;
        int middle;
        if(arr.length % 2 == 0) {
            middle = arr.length/2;
        } else {
            middle = arr.length/2 + 1;
        }
        while ((start != arr.length/2 && middle != arr.length) && middle <= arr.length) {
            int temp = arr[start];
            arr[start] = arr[middle];
            arr[middle] = temp;

            start += 2;
            middle += 2;
        }
    }



    private static void swap(int left, int right) {
        int temp = left;
        left = right;
        right = temp;
    }
}
