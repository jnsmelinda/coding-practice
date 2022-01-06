package leetcode.p706_desing_hash_map;

import java.util.Arrays;

public class MyHashMap {
    public static void main(String[] args) {
        MyHashMapAnswer obj = new MyHashMapAnswer();
        int key = 10;
        int value = key * 5;
        obj.put(key,value);
        int param_2 = obj.get(key);
        obj.remove(key);
    }


    public static class MyHashMapAnswer {

        int[] map;
        public MyHashMapAnswer() {
            map = new int[1000001];
            Arrays.fill(map, -1);
        }

        public void put(int key, int value) {
            map[key] = value;
        }

        public int get(int key) {
            return map[key];
        }

        public void remove(int key) {
            map[key] = -1;
        }

        @Override
        public String toString() {
            return "MyHashMapAnswer{" +
                "map=" + Arrays.toString(map) +
                '}';
        }
    }
}
