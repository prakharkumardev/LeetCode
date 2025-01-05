package code.dpOnSubsequence;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class coinChange {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE); // Initialize dp with max value
        dp[0] = 0; // Base case: 0 coins needed to make amount 0

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 && dp[i - coins[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];

    }


    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        for(int i = 0;i<=coins.length;i++){
            for(int j = 0;j<=amount;j++){
                dp[i][j] = -1;
            }
        }
        return ways(coins, dp, amount, 0);
    }

    private int ways(int[] coins, int[][] dp, int amount, int index){
        if(amount<0 || index>=coins.length){
            return 0;
        }
        if(amount == 0){
            return 1;
        }
        if(dp[index][amount] != -1 ){
            return dp[index][amount];
        }
        int pick = ways(coins, dp, amount-coins[index], index+1);
        int notPick = ways(coins, dp, amount, index+1);
        dp[index][amount] = pick + notPick;
        return dp[index][amount];
    }

}
