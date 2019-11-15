package ctci.arrayandstring;

import java.util.HashMap;
import java.util.Map;

public class PalindromePermutation {
    public static boolean isPermutationOfPalindrome(String str) {
        Map<Character, Integer> frequencies = getFrequencies(str);

        if (countOddValues(frequencies) > 1) {
            return false;
        }
        return true;
    }

    private static int countOddValues(Map<Character, Integer> frequencies) {
        int odds = 0;
        for (Integer value : frequencies.values()) {
            if (value % 2 != 0) {
                odds++;
            }
        }
        return odds;
    }

    private static Map getFrequencies(String str) {
        Map<Character, Integer> frequencies = new HashMap();
        for (int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);
            if (ch != ' ') {
                if (frequencies.containsKey(ch)) {
                    frequencies.put(ch, frequencies.get(ch) + 1);
                } else {
                    frequencies.put(ch, 1);
                }
            }
        }

        return frequencies;
    }

    public static void main(String[] args) {
        String[] words = {"tacc     at", "aaabbcbbaaa", "vvv fff gggg", "dcvgtdc"};
        for (String word : words) {
            System.out.println("word:" + word + " " + isPermutationOfPalindrome(word));
        }
    }
}
