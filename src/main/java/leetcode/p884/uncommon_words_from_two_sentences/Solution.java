package leetcode.p884.uncommon_words_from_two_sentences;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public static void main(String[] args) {
        String s1 = "s z z z s";
        String s2 = "s z ejt";

        System.out.println(Arrays.toString(uncommonFromSentences(s1, s2)));
    }

    public static String[] uncommonFromSentences(String s1, String s2) {
        List<String> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        String[] s1Arr = s1.split(" ");
        String[] s2Arr = s2.split(" ");

        for (int i = 0; i < s1Arr.length; i++) {
            map.put(s1Arr[i], map.getOrDefault(s1Arr[i], 0) + 1);
        }

        for (int i = 0; i < s2Arr.length; i++) {
            map.put(s2Arr[i], map.getOrDefault(s2Arr[i], 0) + 1);
        }

        for (String key : map.keySet()){
            if (map.get(key) == 1) {
                list.add(key);
            }
        }

        String[] result = new String[list.size()];
        return list.toArray(result);
    }
}
