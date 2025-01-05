package code.dpOnSubsequence;

public class isSubsetSum {
    static Boolean isSubsetSum(int arr[], int target) {
        // code here
        Boolean[][] dp = new Boolean[arr.length+1][target+1];
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<=target; j++){
                dp[i][j] = null;
            }
        }
        return isSum(arr, target, dp, 0);
        //return false;
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
        Boolean notPick = isSum(arr, target, dp, index+1);
        dp[index][target] = pick || notPick;
        return dp[index][target];
    }
}
