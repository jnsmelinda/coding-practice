package leetcode.p322_coin_change;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {3,4,5};
        System.out.println(coinChange(coins, 2));
    }

    public static int coinChange(int[] coins, int change) {
        int[] dp = new int[change + 1];
        Arrays.fill(dp, change + 1);
        dp[0] = 0;
        System.out.println(Arrays.toString(dp));
        for (int i = 0; i <= change; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                    System.out.println(Arrays.toString(dp));
                }
                else {
                    break;
                }
            }
        }

        return dp[change] > change ? -1 : dp[change];
    }
}
