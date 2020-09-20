package leetcode.p387_first_unique_char;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueChar {
    public static void main(String[] args) {
        String st = "leetcode";
        String s = "loveleetcode";
        System.out.println(firstUniqeChar(st));
        System.out.println(firstUniqeChar(s));
    }
    public static int firstUniqeChar(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        for (int i = 0; i < s.length(); i++)
            if (map.get(s.charAt(i)) == 1) { return i; }

        return -1;
    }
}
