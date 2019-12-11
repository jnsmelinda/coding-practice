package ctci.recursionanddynamic;

import java.util.Arrays;

public class Coins {

    public static void main(String[] args) {
        System.out.println(coins(10));
    }

    public static int coins(int n) {
        int[] coins = {25, 10, 5, 1};
        return coins(n, coins, 0);
    }

    private static int coins(int n, int[] coins, int counter) {
        if (n - coins[0] > 0) {
            return coins(coins[0], Arrays.copyOfRange(coins, 1,coins.length), counter++);
        }
        else {
            return coins(n - (coins[0]), Arrays.copyOfRange(coins, 1,coins.length), counter++);
        }
    }
}
