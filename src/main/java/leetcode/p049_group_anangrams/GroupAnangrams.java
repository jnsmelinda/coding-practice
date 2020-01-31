package leetcode.p049_group_anangrams;

import java.util.*;

public class GroupAnangrams {
    public static void main(String[] args) {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(sort(input[3]));


        System.out.println(groupAnagrams(input));
        //Output:
        //  ["ate","eat","tea"] , ["nat","tan"] , ["bat"]
    }

    public static List<List<String>> groupAnagrams(String[] input) {
        Map<String, List<String>> result = new HashMap();

        for (int i = 0; i < input.length; i++) {
            String current = sort(input[i]);
            if (!result.containsKey(current)) {
                result.put(current, new ArrayList<>());
            }
            result.get(current).add(input[i]);
        }

        List<List<String>> list = new ArrayList<>();
        for (List values : result.values()) {
            list.add(values);
        }

        return list;
    }

    private static String sort(String str) {
        char[] ordered = str.toCharArray();
        Arrays.sort(ordered);
        return new String(ordered);
    }
}
