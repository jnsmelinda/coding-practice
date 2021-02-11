package leetcode.p1160_find_words_that_can_be_formed_by_characters;

import java.util.Arrays;

public class FindWordsThatCanBeFormedByCharacters {
    public static void main(String[] args) {
        String[] arr = {"hello","world","leetcode"};
        System.out.println(countCharacters(arr, "welldonehoneyr"));
    }

    public static int countCharacters(String[] words, String chars) {
        char[] charsArray = chars.toCharArray();
        Arrays.sort(charsArray);
        int res = 0;

        for (int i = 0; i < words.length; i++) {
            char[] splitword = words[i].toCharArray();
            Arrays.sort(splitword);
            int counter = 0;

            for (int j = 0; j < charsArray.length; j++) {
                if (charsArray[j] == splitword[counter]) {
                    counter++;
                }
                if (counter == splitword.length) {
                    break;
                }
            }
            if (counter == splitword.length) {
                res += counter;
            }
        }
        return res;
    }
}
