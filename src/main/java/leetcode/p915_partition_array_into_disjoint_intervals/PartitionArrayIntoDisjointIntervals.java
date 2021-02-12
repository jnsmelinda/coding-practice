package leetcode.p915_partition_array_into_disjoint_intervals;

public class PartitionArrayIntoDisjointIntervals {

    public static void main(String[] args) {
        int[] arr = {5,0,3,6,8};
        System.out.println(partitionDisjoint(arr));
    }

    public static int partitionDisjoint(int[] A) {
        int result = 0;
        int max = A[0];
        int currMax = A[0];
        for (int i = 1; i < A.length; i++) {
            if (A[i] < max) {
                result = i;
                max = currMax;
            }
            currMax = Math.max(currMax, A[i]);
        }

        return result + 1;
    }
}
