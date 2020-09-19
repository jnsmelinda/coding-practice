package leetcode.p146_lru_chace;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LRUChace {
    Queue<Integer> queue = new LinkedList<>();
    Map<Integer,Integer> cache = new HashMap<>();
    Map<Integer,Integer> count = new HashMap<>();
    int capacity;

    public LRUChace(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if(!cache.containsKey(key)) {
            return -1;
        }
        queue.offer(key);
        count.put(key, count.get(key) + 1);
        return cache.get(key);
    }

    public void put(int key, int value) {
        System.out.println(cache);
        System.out.println(count);
        System.out.println(queue);
        cache.put(key, value);
        count.put(key, count.getOrDefault(key, 0) + 1);
        queue.offer(key);
        int size = cache.size();
        while(size > capacity) {
            int p = queue.poll();
            int t = count.get(p);
            count.put(p, t - 1);
            if (t == 1) {
                count.remove(p);
                cache.remove(p);
                size--;
            }
        }
    }
}
