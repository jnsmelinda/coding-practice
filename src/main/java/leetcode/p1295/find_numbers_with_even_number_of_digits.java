package leetcode.p1295;

import java.util.Arrays;

public class find_numbers_with_even_number_of_digits {
    public static void main(String[] args) {
        int[] arr = {12,345,2,6,7896};
        System.out.println(findNumbers(arr));
    }

    public static int findNumbers(int[] nums) {
         int evens = 0;

         for (int i = 0; i < nums.length; i++) {
             int digits = 0;
             while(nums[i] > 0) {
                 nums[i] = nums[i] / 10;
                 digits++;
             }
             if (digits % 2 == 0) {
                 evens++;
             }
         }

         return evens;
    }

//    Another implementation
    public static int find(int[] nums) {

            return (int) Arrays.stream(nums)
                .mapToObj(num -> String.valueOf(num))
                .filter(str -> str.length() % 2 == 0)
                .count();

    }
}
