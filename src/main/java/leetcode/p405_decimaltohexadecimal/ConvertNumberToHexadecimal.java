package leetcode.p405_decimaltohexadecimal;

import java.util.Stack;

public class ConvertNumberToHexadecimal {
    public static void main(String[] args) {
        System.out.println(decimalToHexadecimal(-3));
    }

    public static String decimalToHexadecimal(int num) {
        Stack<Integer> stack = new Stack();
        StringBuilder result = new StringBuilder();
        String[] arr = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
        int remainder = Integer.MAX_VALUE;
        if (num == 0) {
            return "0";
        }
        if (num < 0) {
            num = Math.abs(num);
            while (remainder != 0) {
                int quotient = num / 2;
                remainder = num % 2;
                stack.push(remainder);
                num = quotient;
            }

            System.out.println(stack);
        }
        else {
            while (remainder != 0) {
                int quotient = num / 16;
                remainder = num % 16;
                stack.push(remainder);
                num = quotient;
            }
        }
        if (stack.peek() == 0) {
            stack.pop();
        }
        while (!stack.isEmpty()) {
            result.append(arr[stack.pop()]);
        }
        return result.toString();
    }
}
