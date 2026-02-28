package leetcode.p3442_maximum_difference_between_even_and_odd_frequency_I;

import java.util.HashMap;

class Solution {

    public static void main(String[] args) {
        String s = "abcabcab";
        System.out.println(maxDifference(s));
    }

    public static int maxDifference(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        HashMap<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char word = s.charAt(i);
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (Integer value : freq.values()){
            if (value < min && value % 2 == 0) {
                min = value;
            }
            if (value > max && value % 2 != 0) {
                max = value;
            }
        }

        return max - min;
    }
}
