package leetcode.p1798_MaxNumofConsecutiveVals;

import java.util.Arrays;

public class MaxNumofConVals {

    public static void main(String[] args) {
        int[] arr = {1,1,1,4};
        System.out.println(getMaximumConsecutive(arr));
    }

    public static int getMaximumConsecutive(int[] coins) {
        int len = coins.length;
        Arrays.sort(coins);
        int ans = 1;
        for(int i = 0 ; i < len ; i++) {
            if(coins[i] > ans) break;
            ans += coins[i];
        }
        return ans;
    }
}
