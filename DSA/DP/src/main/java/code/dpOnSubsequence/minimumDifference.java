package code.dpOnSubsequence;

public class minimumDifference {
    public int minimumDifference(int[] nums) {
        int sum = 0;
        for(int num: nums){
            sum+=num;
        }
        int target = sum/2;
        for(int i = target; i>=0; i--){
            Boolean[][] dp = new Boolean[nums.length+1][i+1];
            if(isSum(nums, i, dp, 0, 0)){
                return sum-2*i;
            }
        }
        return -1;
    }

    private static Boolean isSum(int arr[], int target, Boolean[][]dp, int index, int selectedElements){
        if(target==0 && selectedElements == arr.length/2){
            dp[index][target] = true;
            return true;
        }
        if(target<0 || index>=arr.length|| selectedElements>=arr.length/2){
            return false;
        }
        if(dp[index][target]!=null){
            return dp[index][target];
        }
        Boolean pick = isSum(arr, target-arr[index], dp, index+1, selectedElements+1);
        Boolean notPick = isSum(arr, target, dp, index+1, selectedElements);
        dp[index][target] = pick || notPick;
        return dp[index][target];
    }
}
