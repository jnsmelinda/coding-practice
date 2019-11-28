package ctci.recursionanddynamic;

import java.lang.reflect.Array;
import java.util.*;

public class SubsetOfSets {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(powerSetIterative(list));
        System.out.println(powerSetRecursion(list, 0));
    }

    public static List<List<Integer>> powerSetIterative(List<Integer> list) {
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

    public static ArrayList<ArrayList<Integer>> powerSetRecursion(List<Integer> set, int index) {
        ArrayList<ArrayList<Integer>> allSubSets;
        if (set.size() == index) {
            allSubSets = new ArrayList<>();
            allSubSets.add(new ArrayList<>());
        }
        else {
            allSubSets = powerSetRecursion(set, index + 1);
            int item = set.get(index);
            ArrayList<ArrayList<Integer>> moreSubSets = new ArrayList<>();
            for (ArrayList<Integer> subSet : allSubSets) {
                ArrayList<Integer> newSubSets = new ArrayList<>();
                newSubSets.addAll(subSet);
                newSubSets.add(item);
                moreSubSets.add(newSubSets);
            }
            allSubSets.addAll(moreSubSets);
        }
        return allSubSets;
    }
}
