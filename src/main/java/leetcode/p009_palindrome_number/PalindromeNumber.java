package leetcode.p009_palindrome_number;

public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome(1010));
    }

    public static boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int begin = 0;
        int end = s.length() - 1;

        while (begin <= end) {
            if (s.charAt(begin) != s.charAt(end)) {
                return false;
            }
            begin ++;
            end--;
        }
        return true;
    }
}
