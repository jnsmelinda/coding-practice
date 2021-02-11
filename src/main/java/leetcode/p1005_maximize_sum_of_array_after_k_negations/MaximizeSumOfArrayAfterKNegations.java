package leetcode.p1005_maximize_sum_of_array_after_k_negations;

import java.util.PriorityQueue;

public class MaximizeSumOfArrayAfterKNegations {

    public static void main(String[] args) {
        int[] arr = {2,-3,-1,5,-4};
        System.out.println(largestSumAfterKNegations(arr, 2));
    }

    public static int largestSumAfterKNegations(int[] A, int K) {
        int sum = 0;

        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i= 0; i < A.length; i++) {
            q.add(A[i]);
        }

        for (int i = 0; i < K; i++) {
            q.add(q.poll() *-1);
        }

        for (Integer e : q) {
            sum += e;
        }

        return sum;
    }
}
