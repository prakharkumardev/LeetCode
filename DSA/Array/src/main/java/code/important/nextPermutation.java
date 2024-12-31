package code.important;

import java.util.Arrays;

public class nextPermutation {
    public void nextPermutation(int[] nums) {
        int pivot = -1;
        for(int i = nums.length;i>0;i--){
            if(nums[i]>nums[i-1]){
                pivot = i-1;
            }
        }
        if(pivot == -1) Arrays.sort(nums);
        //find next bigger element
        int nextBiggerElementIndex = -1;
        for(int i = nums.length-1;i>pivot;i--){
            if(nums[i]>nums[pivot]){
                nextBiggerElementIndex = i;
                break;
            }
        }
        //swap
        int temp = nums[pivot];
        nums[pivot] = nums[nextBiggerElementIndex];
        nums[nextBiggerElementIndex] = temp;
        Arrays.sort(nums, pivot+1, nums.length);
    }
}
