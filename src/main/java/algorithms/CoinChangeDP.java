package algorithms;

import java.util.Arrays;

public class CoinChangeDP {

  public static int coinChange(int[] coins, int amount) {
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, amount + 1);
    dp[0] = 0;

    for (int i = 1; i <= amount; i++) {
      for (int coin : coins) {
        if (coin <= i) {
          dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
        }
      }
    }

    return dp[amount] > amount ? -1 : dp[amount];
  }

  public static void main(String[] args) {
    int[] coins = {1, 2, 5};
    int amount = 11;

    int minCoins = coinChange(coins, amount);
    System.out.println("Minimum number of coins: " + minCoins);
  }
}