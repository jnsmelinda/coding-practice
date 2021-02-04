package leetcode.p0495_teemo_attacking;

public class TeemoAttacking {

    public static void main(String[] args) {
        int[] arr = {1,2};
        System.out.println(findPoisonedDuration(arr, 2));
    }

    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        int result = 0;
        int attackEnd = 0;

        for (int i = 0; i < timeSeries.length; i++) {
            if (timeSeries[i] >= attackEnd) {
                result += duration;
                attackEnd = timeSeries[i] + duration;
            }
            else {
                attackEnd += timeSeries[i] - timeSeries[i-1];
                result += timeSeries[i] - timeSeries[i-1];
            }
        }

        return result;
    }
}
