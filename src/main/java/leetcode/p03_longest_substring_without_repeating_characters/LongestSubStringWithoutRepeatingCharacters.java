package leetcode.p03_longest_substring_without_repeating_characters;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() < 1) {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }

        int leftPointer = 0, rightPointer = 0, max = 0;
        Set<Character> set = new HashSet<>();

        while (rightPointer < s.length()) {
            if (!set.contains(s.charAt(rightPointer))) {
                set.add(s.charAt(rightPointer++));
                max = Math.max(max, set.size());
            }
            else {
                set.remove(s.charAt(leftPointer++));
            }
        }

        return max;
    }
}
