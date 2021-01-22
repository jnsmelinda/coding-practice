package leetcode.p014.longest_common_prefix;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] arr = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(arr));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String str = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(str) != 0) {
                str = str.substring(0, str.length() - 1);
            }
        }

        return str;
    }
}
