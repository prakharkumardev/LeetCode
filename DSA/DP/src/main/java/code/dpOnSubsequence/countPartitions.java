package code.dpOnSubsequence;

public class countPartitions {
    int countPartitions(int[] arr, int d) {
        int totalSum = 0;
        for(int num: arr){
            totalSum +=num;
        }

        if(totalSum -d<0) return 0;
        if((totalSum -d)%2==1) return 0;
        int[] dp = new int[arr.length+1];
        return countWays(arr, totalSum,0, dp, 0,d);
    }
    int countWays(int[] arr, int totalSum,int sum, int[] dp, int index , int diffrence){

        System.out.println("totalsum : "+ totalSum + " sum: "+ sum + " diffrence: "+ (totalSum-sum) + " dp[index] :"+ dp[index] );

        if(totalSum - sum == diffrence){
            return 1;
        }
        if(index > arr.length-1){
            return 0;
        }
        if (dp[index] != 0) {
            return dp[index];
        }
        int pick = countWays(arr, totalSum, sum+arr[index], dp, index+1, diffrence);
        int notPick = countWays(arr, totalSum, sum, dp, index+1, diffrence);
        dp[index] = pick + notPick;
        return dp[index];
    }
}
