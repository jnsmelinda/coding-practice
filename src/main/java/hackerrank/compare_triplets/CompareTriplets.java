package hackerrank.compare_triplets;

import java.util.ArrayList;
import java.util.List;

public class CompareTriplets {
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(17);
        a.add(28);
        a.add(30);
        List<Integer> b = new ArrayList<>();
        b.add(99);
        b.add(16);
        b.add(8);
        System.out.println(compareTriplets(a,b));
    }

    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {

        List<Integer> list= new ArrayList();
        list.add(0, 0);
        list.add(1, 0);

        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) > b.get(i)) {
                int current = list.get(0);
                current++;
                list.set(0, current);
            }
            else if (a.get(i) < b.get(i)){
                int current = list.get(1);
                current++;
                list.set(1, current);
            }
        }

        return list;
    }
}
