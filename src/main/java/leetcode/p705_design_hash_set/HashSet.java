package leetcode.p705_design_hash_set;

import java.util.Arrays;

public class HashSet {
    public static void main(String[] args) {
        MyHashSet obj = new MyHashSet();
        int key = 2;
        obj.add(key);
        obj.remove(key);
        boolean param_3 = obj.contains(key);
    }
    public static class MyHashSet {

        int[] set;

        public MyHashSet() {
            set = new int[1000001];
            Arrays.fill(set, -1);
        }

        public void add(int key) {
            set[key] = key;
        }

        public int get(int key) {
            return set[key];
        }

        public void remove(int key) {
            set[key] = -1;
        }

        public boolean contains(int key) {
            if (set[key] == -1) {
                return false;
            }
            return true;
        }

        @Override
        public String toString() {
            return "set=" + Arrays.toString(set);
        }
    }
}
