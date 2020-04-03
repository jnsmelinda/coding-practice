package leetcode.p66_plus_one;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        int[] digit = {8,0,9};
        System.out.println(Arrays.toString(plusOne(digit)));
    }
    public static int[] plusOne(int[] digits) {
        int index = digits.length - 1;
        digits[digits.length - 1]++;
        while (digits[index] > 9) {
            digits[index] = digits[index] - 10;
            if (index == 0) {
                return makeNew(digits);
            }
            index--;
            digits[index]++;
        }

        return digits;
    }

    public static int[] makeNew(int[] digits) {
        int[] newResult = new int[digits.length + 1];
        newResult[0] = 1;
        return newResult;
    }
}
