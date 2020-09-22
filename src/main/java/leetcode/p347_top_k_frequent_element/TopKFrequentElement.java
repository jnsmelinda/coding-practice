package leetcode.p347_top_k_frequent_element;

import java.util.*;

public class TopKFrequentElement {

    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3,4,4,4,4};
        System.out.println(Arrays.toString(topKFrequent(arr, 2)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], 0);
            map.put(nums[i], map.get(nums[i]) + 1);
        }

        MyComparator comparator = new MyComparator(map);
        Map<Integer, Integer> newMap = new TreeMap<>(comparator);
        newMap.putAll(map);

        int[] result = new int[k];
        int counter = 0;
        for (Integer key : newMap.keySet()) {
            if (counter == k) {
                break;
            }
            result[counter] = key;
            counter++;
        }

        return result;
    }

    static class MyComparator implements Comparator<Object> {

        Map<Integer, Integer> map;

        public MyComparator(Map<Integer, Integer> map) {
            this.map = map;
        }

        public int compare(Object o1, Object o2) {
            if (map.get(o2) == map.get(o1)) {
                return 1;
            }
            else {
                return (map.get(o2)).compareTo(map.get(o1));
            }
        }
    }
}
