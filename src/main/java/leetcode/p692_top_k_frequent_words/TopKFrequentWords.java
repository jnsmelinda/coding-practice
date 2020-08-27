package leetcode.p692_top_k_frequent_words;

import java.util.*;

public class TopKFrequentWords {

    public static void main(String[] args) {
        String[] arr = {"i", "love", "leetcode", "i", "love", "coding"};
        System.out.println(topKFrequent(arr, 1));
    }

    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new TreeMap<>();
        List<String> result = new ArrayList<>();

        for(int i = 0; i < words.length; i++) {
            map.putIfAbsent(words[i], 0);
            map.put(words[i], map.get(words[i]) + 1);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if( o2.getValue() == o1.getValue()) {
                    return o1.getKey().compareTo(o2.getKey());
                }
                return o2.getValue() - o1.getValue();
            }
        });

        for(int i = 0; i < k; i++) {
            result.add(list.get(i).getKey());
        }

        return result;
    }
}
