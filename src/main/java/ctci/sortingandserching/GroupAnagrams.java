package ctci.sortingandserching;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
    String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(sort(input[3]));


        System.out.println(groupAnagrams(input));
    //Output:
        //  ["ate","eat","tea"] , ["nat","tan"] , ["bat"]
    }

    public static Collection<List<String>> groupAnagrams(String[] input) {
        Map<String, List<String>> result = new HashMap();

        for (int i = 0; i < input.length; i++) {
            String current = sort(input[i]);
            if (!result.containsKey(current)) {
                result.put(current, new ArrayList<>());
            }
            result.get(current).add(input[i]);
        }

        return result.values();
    }

    private static String sort(String str) {
        char[] ordered = str.toCharArray();
        Arrays.sort(ordered);
        return new String(ordered);
    }
}
