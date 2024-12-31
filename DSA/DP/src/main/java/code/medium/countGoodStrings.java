package code.medium;

public class countGoodStrings {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int mod = 100_000_000_7;
        int[] dp = new int[high+1];

        dp[0] = 1;
        for(int i=1;i<=high;i++){
            if(i-zero>=0){
                dp[i] = (dp[i] + dp[i-zero])%mod;
            }
            if(i-one>=0){
                dp[i] = (dp[i] + dp[i-one])%mod;
            }
        }
        long count  = 0;
        for(int i = low;i<=high;i++){
           count = (count + dp[i])%mod;
        }

        return (int)count;
    }
}
