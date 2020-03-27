package leetcode.p125_valide_palindrome;

public class ValidePalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        System.out.println(s.length()/2);
    }

    public static boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        if (s.isEmpty()) {
            return true;
        }

        char[] ch = s.toCharArray();

        int begin = 0;
        int end = ch.length-1;

        while(begin <= end) {
            if (ch[end] != ch[begin]) {
                return false;
            }
            else {
                end--;
                begin++;
            }
        }
        return true;
    }
}
