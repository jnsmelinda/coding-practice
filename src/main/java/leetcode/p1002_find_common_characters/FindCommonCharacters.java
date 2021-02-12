package leetcode.p1002_find_common_characters;

import java.util.*;
import java.util.stream.Collectors;

public class FindCommonCharacters {
    public static void main(String[] args) {
        String[] arr = {"bella","label","roller"};
        System.out.println(commonChars(arr));
        System.out.println(commonChars2(arr));
    }

    public static List<String> commonChars(String[] A) {
        List<int[]> list = new ArrayList<>();

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
                    result.add(String.valueOf((char)(i + 'a')));
                    counter++;
                }
            }
        }

        return result;
    }

    public static List<String> commonChars2(String[] A) {
        List<Map<Character, Integer>> freqs = Arrays.stream(A)
            .map(FindCommonCharacters::frequencies)
            .collect(Collectors.toList());

        Set<Character> intersection = freqs.get(0).keySet();
        for (Map<Character, Integer> freqMap : freqs) {
            intersection.retainAll(freqMap.keySet());
        }

        List<String> result = new ArrayList<>();
        for (Character ch : intersection) {
            int min = Integer.MAX_VALUE;
            for (Map<Character, Integer> freqMap : freqs) {
                min = Math.min(min, freqMap.get(ch));
            }

            for (int i = 0; i < min; i++) {
                result.add(String.valueOf(ch));
            }
        }

        return result;
    }

    private static Map<Character, Integer> frequencies(String word) {
        return word.chars()
            .mapToObj(character -> (char) character)
            .collect(Collectors.toMap(k -> k, v -> 1, (v1, v2) -> v1 + 1, HashMap::new));
    }
}
