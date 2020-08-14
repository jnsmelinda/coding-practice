package hackerrank.a_very_big_sum;

public class VeryBigSum {
    public static void main(String[] args) {
        long[] ar = {1000000001, 1000000002, 1000000003, 1000000004, 1000000005};
        System.out.println(aVeryBigSum(ar));
    }

    public static long aVeryBigSum(long[] ar) {
        long result = 0;
        for (int i = 0; i < ar.length; i++) {
            result += ar[i];
        }

        return result;
    }
}
