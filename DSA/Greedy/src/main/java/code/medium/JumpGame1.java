package code.medium;

import java.util.Arrays;

public class JumpGame1 {
    public boolean canJump(int[] nums) {
        int dp[] = new int[nums.length+1];
        Arrays.fill(dp,-1);
        return canReach(nums, dp, 0) == 1;
    }

    private int  canReach(int[] nums,int[] dp, int index){
        if(index == nums.length-1){
            return 1;
        }
        if(index > nums.length -1 || nums[index] == 0){
            return 0;
        }
        if(dp[index] != -1){
            return dp[index];
        }
        for (int i = 1; i <= nums[index]; i++) { // Fix: nums[index] instead of nums[i]
            if (canReach(nums, dp, index + i) == 1) {
                dp[index] = 1; // Mark as reachable
                return 1;
            }
        }

        dp[index] = 0; // Mark as not reachable
        return 0;
    }

    public boolean canJumpGreedy(int[] nums) {
        int maxIndex = 0;
        for(int i = 0;i<nums.length;i++){
            if(i>maxIndex){
                return false;
            }
            maxIndex = Math.max(maxIndex, i + nums[i]);
            if(maxIndex >= nums.length-1){
                return true;
            }
        }
        return false;
    }
}
