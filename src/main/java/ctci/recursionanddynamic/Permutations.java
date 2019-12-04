package ctci.recursionanddynamic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Permutations {
    public static void main(String[] args) {
         String szo = "abcc";
        System.out.println(permutWithDup(szo));
//        System.out.println(Arrays.asList(szo.split("")));
    }

    public static ArrayList<String> permutNoDupChs(String szo) {
        ArrayList<String> list = new ArrayList<>();
        if (szo.length() == 0) {
            list.add("");
            return list;
        }
        ArrayList<String> words = permutNoDupChs(szo.substring(1));
        for (String word : words) {
            for (int i = 0; i <= word.length(); i++) {
                list.add(word.substring(0, i) + szo.charAt(0) + word.substring(i));
            }
        }
        return list;
    }

    public static ArrayList<String> permutWithDup(String szo){
        return makePerms(getFrequencies(szo), "", szo.length(), new ArrayList());
    }

    private static ArrayList<String> makePerms(Map<Character, Integer> map, String str,
                                               int length, ArrayList result) {
        if (length == 0) {
            result.add(str);
            return result;
        }
        for (Character ch : map.keySet()) {
            int count = map.get(ch);
            if (count > 0) {
                map.put(ch, count - 1);
                makePerms(map, str + ch, length - 1, result);
                map.put(ch, count);
            }
        }
        return result;
    }

    private static Map getFrequencies(String str) {
        Map<Character, Integer> frequencies = new HashMap();
        for (Character ch : str.toCharArray()) {
            if (!frequencies.containsKey(ch)) {
                frequencies.put(ch, 0);
            }
            frequencies.put(ch, frequencies.get(ch) + 1);
        }
        return frequencies;
    }
}
