package leetcode.p1525_number_of_sub_arrays_with_odd_sum;

public class NumberOfSubArraysWithOddSum {

    public static void main(String[] args) {
        int[] arr = {1,3,5};
        System.out.println(numOfSubarrays(arr));
    }

    public static int subs(int[] arr) {
        int counter = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
                if (sum % 2 != 0) {
                    counter++;
                }
                sum = 0;
            }
        }
        return counter;
    }

    public static int numOfSubarrays(int[] arr) {
        int[] count = new int[2];
        count[0] = 1;
        long res = 0;
        int sum = 0;
        int mod = 1000000007;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            int index = sum % 2;
            count[index]++;

            if (index == 0) {
                index = 1;
            }
            else {
                index = 1;
            }
            res += count[index];
            res %= mod;
        }
        return (int) res;
    }
}
