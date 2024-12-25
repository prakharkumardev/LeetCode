package code.medium;

public class sortedTwoSum {
    public int[] twoSum(int[] nums, int target) {
        int s = 0 ;
        int e = nums.length-1;
        while(s<e){
            int sum = nums[s] + nums[e];
            if( sum == target){
                return new int[]{s,e};
            }else if(sum < target){
                s++;
            }else {
                e--;
            }
        }
        return new int[]{-1,-1};
    }
}
