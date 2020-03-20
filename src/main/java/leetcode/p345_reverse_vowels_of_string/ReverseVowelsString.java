package leetcode.p345_reverse_vowels_of_string;

public class ReverseVowelsString {
    public static void main(String[] args) {
        String test = "hello";
        System.out.println(reverseVowels(test));
    }

    public static String reverseVowels(String s) {
        char[] sChar = s.toCharArray();

        int left = 0;
        int right = s.length() - 1;

        while (left <= right) {
            if (isVowel(sChar[left]) && isVowel(sChar[right])) {
                char temp = sChar[left];
                sChar[left] = sChar[right];
                sChar[right] = temp;
                left++;
                right--;
            }
            else if (isVowel(sChar[left]) && !isVowel(sChar[right]))
                right--;
            else if (!isVowel(sChar[left]) && isVowel(sChar[right]))
                left++;
            else {
                left++;
                right--;
            }
        }

        return String.valueOf(sChar);
    }

    private static boolean isVowel(char ch) {
        return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
            ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U');
    }
}
