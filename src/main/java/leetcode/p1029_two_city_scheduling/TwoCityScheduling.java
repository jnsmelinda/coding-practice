package leetcode.p1029_two_city_scheduling;

import java.util.Arrays;
import java.util.Comparator;

public class TwoCityScheduling {
    public static void main(String[] args) {
        int[][] arr = {{400,50},{10,20},{30,200},{30,20}};
        System.out.println(twoCitySchedCost(arr));
    }

    public static int twoCitySchedCost(int[][] costs) {
        int result = 0;
        System.out.println(Arrays.deepToString(costs));
        Arrays.sort(costs, new CompareCosts());
        System.out.println(Arrays.deepToString(costs));

        int tripA = costs.length / 2;
        int tripB = costs.length / 2;
        for (int i = costs.length - 1; i >= 0; i--) {
            if (tripB == 0 || (costs[i][0] < costs[i][1] && tripA > 0)) {
                result += costs[i][0];
                tripA--;
            }
            else if (tripA == 0 || (costs[i][0] > costs[i][1] && tripB > 0)) {
                result += costs[i][1];
                tripB--;
            }
            else {
                if (tripA > tripB) {
                    result += costs[i][0];
                    tripA--;
                } else {
                    result += costs[i][1];
                    tripB--;
                }
            }
        }

        return result;
    }

}
class CompareCosts implements Comparator<int[]> {
    public int compare(int[] A, int[] B) {
        return Math.abs(A[0] - A[1]) - Math.abs(B[0] - B[1]);
    }
}
