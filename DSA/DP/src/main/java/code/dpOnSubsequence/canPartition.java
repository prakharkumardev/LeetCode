package code.dpOnSubsequence;

public class canPartition {
    public boolean canPartition(int[] nums) {
        int sum  = 0;
        for(int num: nums){
            sum+=num;
        }
        if(sum%2 != 0) return false;
        int target = sum/2;
        Boolean[][] dp = new Boolean[nums.length+1][target+1];
        return isSum(nums, target, dp, 0);

    }
    private static Boolean isSum(int arr[], int target, Boolean[][]dp, int index){
        if(target== 0){
            dp[index][target] = true;
            return true;
        }
        if(target<0 || index>=arr.length){
            return false;
        }
        if(dp[index][target]!=null){
            return dp[index][target];
        }
        Boolean pick = isSum(arr, target-arr[index], dp, index+1);
        if(pick){
            dp[index][target] = true;
            return pick;
        }

        Boolean notPick = isSum(arr, target, dp, index+1);
        dp[index][target] = pick || notPick;
        return dp[index][target];

    }
}
