package ctci.arrayandstring;

public class OneAway {
    public static boolean isOneEditAway(String s1, String s2) {
        if (s1 == null || s2 == null || Math.abs(s1.length() - s2.length()) > 1) {
            return false;
        }

        String str1 = s1.length() < s2.length() ? s1 : s2;
        String str2 = s1.length() < s2.length() ? s2 : s1;

        int str1Index = 0;
        int str2Index = 0;
        boolean foundDiff = false;
        while (str1Index < str1.length() && str2Index < str2.length()) {
            if (str1.charAt(str1Index) != str2.charAt(str2Index)) {
                if (foundDiff) {
                    return false;
                }
                foundDiff = true;
                if (str1.length() == str2.length()) {
                    str1Index++;
                }
            } else {
                str1Index++;
            }
            str2Index++;
        }
        return true;
    }

    public static void main(String[] args) {
        String[][] pairs = {{"avcd", "afcd"}};
        for (String[] pair : pairs){
            String word1 = pair[0];
            String word2 = pair[1];
            System.out.println(word1 + ", " + word2 + ": " + isOneEditAway(word1,word2));
        }
    }
}
