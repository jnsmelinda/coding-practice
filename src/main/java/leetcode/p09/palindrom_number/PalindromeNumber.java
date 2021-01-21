package leetcode.p09.palindrom_number;

public class PalindromeNumber {

    public static void main(String[] args) {
        System.out.println(isPalindrome(-121));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int y = x;
        int z = 0;

        while (y != 0) {
            int lastDigit = y % 10;

            if (z != 0) {
                z *= 10;
                z += lastDigit;
            }
            else {
                z += lastDigit;
            }

            y /= 10;
        }

        return x == z;
    }
}
