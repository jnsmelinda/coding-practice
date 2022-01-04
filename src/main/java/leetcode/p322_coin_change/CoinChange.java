package leetcode.p322_coin_change;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1,3,4,5};
        System.out.println(coinChange(coins, 7));
    }

    public static int coinChange(int[] coins, int change) {
        Arrays.sort(coins);
        int[] dp = new int[change + 1];
        Arrays.fill(dp, change + 1);
        dp[0] = 0;
        for (int i = 0; i <= change; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                }
                else {
                    break;
                }
            }
        }

        return dp[change] > change ? -1 : dp[change];
    }
}
