package ctci.recursionanddynamic;

import java.util.*;

public class SubsetOfSets {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(powerSet(list));
    }

    public static List<List<Integer>> powerSet(List<Integer> list) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (Integer item : list) {
            List<List<Integer>> newResult = new ArrayList<>();
            for (List<Integer> subset : result) {
                newResult.add(subset);
                List<Integer> newSubset = new ArrayList<>(subset);
                newSubset.add(item);
                newResult.add(newSubset);
            }
            result = newResult;
        }

        return result;
    }
}
