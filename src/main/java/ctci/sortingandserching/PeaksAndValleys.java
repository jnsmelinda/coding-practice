package ctci.sortingandserching;

import java.util.Arrays;

public class PeaksAndValleys {
    public static void main(String[] args) {
        int[] arr= {1,2,3,4,5,6,7,8,9};
        int[] arr2 = {5,3,1,2,3,0};
//        toPeaksAndValleys1(arr2);
        toPeaksAndValleys2(arr2);
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


    public static void toPeaksAndValleys2(int[] arr) {
        for (int i = 1; i < arr.length; i += 2) {
            int maxIndex;
            if (i+1 >= arr.length) {
                maxIndex = i;
            } else {
                maxIndex = Math.max(i, Math.max(i - 1, i + 1));
            }

            if (arr[maxIndex] == arr[i - 1]) {
//                swap(arr, arr[i - 1], arr[i]);
                int temp = arr[i];
                arr[i] = arr[i - 1];
                arr[i - 1] = temp;
            }
            else if (arr[maxIndex] == arr[i + 1]){
//                swap(arr, arr[i + 1], arr[i]);
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
    }

    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
