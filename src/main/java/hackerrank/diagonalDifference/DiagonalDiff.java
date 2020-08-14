package hackerrank.diagonalDifference;

import java.util.ArrayList;
import java.util.List;

public class DiagonalDiff {
    public static void main(String[] args) {
        List<List<Integer>> arr = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        List<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(5);
        list2.add(6);
        List<Integer> list3 = new ArrayList<>();
        list3.add(9);
        list3.add(8);
        list3.add(9);
        arr.add(list1);
        arr.add(list2);
        arr.add(list3);
        System.out.println(arr);
        System.out.println(diagonalDifference(arr));
    }

    public static int diagonalDifference(List<List<Integer>> arr) {
        int dial1 = 0;
        int dial2 = 0;

        int dial1Index = 0;
        int dial2Index = arr.size()-1;
        for (int i = 0; i < arr.size(); i++) {

            List<Integer> innerList = arr.get(i);
            
            dial1 += innerList.get(dial1Index);
            dial2 += innerList.get(dial2Index);

            dial1Index++;
            dial2Index--;
        }

        return Math.abs(dial1 - dial2);
    }
}
