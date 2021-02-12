package leetcode.p1002_find_common_characters;

import java.util.ArrayList;
import java.util.List;

public class FindCommonCharacters {
    public static void main(String[] args) {
        String[] arr = {"bella","label","roller"};
        System.out.println(commonChars(arr));
    }

    public static List<String> commonChars(String[] A) {
        List<int[]> list = new ArrayList<int[]>();

        for (int i = 0; i < A.length; i++) {
            int[] abc = new int[26];
            for (int j = 0; j < A[i].length(); j++) {
                abc[A[i].charAt(j) - 'a'] += 1;
            }
            list.add(abc);
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < list.get(0).length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < list.size(); j++) {
                min = Math.min(list.get(j)[i], min);
            }
            if (min > 0) {
                int counter = 1;
                while (counter <= min) {
                    StringBuilder sb = new StringBuilder();
                    sb.append((char)(i + 'a'));
                    result.add(sb.toString());
                    counter++;
                }
            }
        }

        return result;
    }
}
