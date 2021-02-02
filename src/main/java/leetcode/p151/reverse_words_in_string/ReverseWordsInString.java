package leetcode.p151.reverse_words_in_string;

public class ReverseWordsInString {
    public static void main(String[] args) {
        System.out.println(reverseWords("  Bob    Loves  Alice   "));
        System.out.println(reverseWords2("  Bob    Loves  Alice   "));
    }

    public static String reverseWords(String s) {
        s = s.trim().replaceAll(" +", " ");
        System.out.println(s);
        String current = "";
        StringBuilder reverse = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                reverse.insert(0, " " + current);
                current = "";
            }
            else {
                current += s.charAt(i);
            }
        }

        reverse.insert(0, current);

        return reverse.toString();
    }

    public static String reverseWords2(String s) {
        s = s.trim();
        String current = "";
        StringBuilder reverse = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                while (s.charAt(i + 1) == ' ') {
                    i++;
                }
                reverse.insert(0, " " + current);
                current = "";
            }
            else {
                current += s.charAt(i);
            }
        }

        reverse.insert(0, current);
        return reverse.toString();
    }
}
