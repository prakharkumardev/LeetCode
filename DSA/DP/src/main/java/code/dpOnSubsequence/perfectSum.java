package code.dpOnSubsequence;

public class perfectSum {
    public int perfectSum(int[] arr, int target) {
        // Create a DP array initialized with -1 (indicating uncomputed states)
        int[][] dp = new int[arr.length][target + 1];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = -1;
            }
        }
        return countSubsets(arr, target, 0, dp);
    }

    private int countSubsets(int[] arr, int target, int index, int[][] dp) {
        // Base cases
        if (target == 0) {
            return 1; // Found a subset
        }
        if (index == arr.length) {
            return 0; // Reached the end without finding a valid subset
        }

        // Check if already computed
        if (dp[index][target] != -1) {
            return dp[index][target];
        }

        // Recursive case: Include or exclude the current element
        int include = 0;
        if (arr[index] <= target) {
            include = countSubsets(arr, target - arr[index], index + 1, dp);
        }
        int exclude = countSubsets(arr, target, index + 1, dp);

        // Store result in DP array
        dp[index][target] = include + exclude;
        return dp[index][target];
    }
}
