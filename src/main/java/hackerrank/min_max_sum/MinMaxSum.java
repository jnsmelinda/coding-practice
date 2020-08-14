package hackerrank.min_max_sum;

import java.util.Arrays;

public class MinMaxSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        miniMaxSum(arr);
    }

    static void miniMaxSum(int[] arr) {
        Arrays.sort(arr);

        long maxSum = arr[arr.length-1];
        long minSum = arr[0];

        for (int i = 1; i < arr.length - 1; i++) {
            maxSum += arr[i];
            minSum += arr[i];
        }

        System.out.println(minSum + " " + maxSum);
    }
}
