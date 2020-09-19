package leetcode.p146_lru_chace;

public class Client {
    public static void main(String[] args) {
        LRUChace obj = new LRUChace(2);
        obj.put(1, 1);
        obj.put(2, 2);
        obj.get(1);
        obj.put(3,3);
        obj.get(1);
        obj.put(4,4);
        obj.get(1);
        obj.get(3);
        obj.get(4);
    }
}
