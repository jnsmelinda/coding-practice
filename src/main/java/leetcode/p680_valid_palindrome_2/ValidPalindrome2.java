package leetcode.p680_valid_palindrome_2;

public class ValidPalindrome2 {
    public static void main(String[] args) {
        System.out.println(validPalindrome("abc"));
    }

    public static boolean validPalindrome(String s) {
        int begin = 0;
        int end = s.length() - 1;

        while (begin < end) {
            if (s.charAt(begin) != s.charAt(end)) {
                return isPalindrome(s, begin + 1, end) || isPalindrome(s, begin, end - 1);
            }
            end--;
            begin++;
        }

        return true;
    }

    public static boolean isPalindrome(String s, int begin , int end){
        while (begin < end){
            if(s.charAt(begin) != s.charAt(end)) {
                return false;
            }
            begin++;
            end--;
        }

        return true;
    }
}
