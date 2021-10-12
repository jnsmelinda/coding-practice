package leetcode.p1480_RunningSumof1dArray;

import java.util.Arrays;

public class p1480_RunningSumof1dArray {
    public static void main(String[] args) {
        int[] nums = {3,1,2,10,1};
        System.out.println(Arrays.toString(runningSum(nums)));
    }

    public static int[] runningSum(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        ans[0] = nums[0];
        for(int i = 1; i < n; i++){
            ans[i] = nums[i]+ans[i-1];
        }
        return ans;
    }
}
