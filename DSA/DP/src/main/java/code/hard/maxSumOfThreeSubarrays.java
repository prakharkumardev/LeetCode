package code.hard;

import java.util.PriorityQueue;

public class maxSumOfThreeSubarrays {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int len = nums.length;
        int[] prefixSum = new int[len];
        prefixSum[0] = nums[0];
        for (int i = 1; i < len; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        int subArrLen = len-k+1;
        int[] subArrSum = new int[subArrLen];
        subArrSum[0] = prefixSum[k - 1];
        for (int i = 1; i < subArrLen; i++) {
            subArrSum[i] = prefixSum[i + k - 1] - prefixSum[i - 1];
        }
        int[] leftMaxIndex = new int[subArrLen];
        int[] rightMaxIndex = new int[subArrLen];
        leftMaxIndex[0] = 0;
        rightMaxIndex[subArrLen - 1] = subArrLen-1;
        int leftMax = subArrSum[0];
        int rightMax = subArrSum[subArrLen-1];
        for(int i = 1;i<subArrLen-1;i++){
            int j = subArrLen-i-1;
            if(leftMax<subArrSum[i]){
                leftMax = subArrSum[i];
                leftMaxIndex[i] = i;
            }else {
                leftMaxIndex[i] = leftMaxIndex[i-1];
            }

            if(rightMax<=subArrSum[j]){
                rightMax = subArrSum[j];
                rightMaxIndex[j] = j;
            }else {
                rightMaxIndex[j] = rightMaxIndex[j+1];
            }
        }
        int maxSum = 0;
        int[] res = new int[3];
        for(int i = k;i<subArrLen-k;i++){
            int sum = subArrSum[i] + subArrSum[leftMaxIndex[i-k]] + subArrSum[rightMaxIndex[i+k]];
            System.out.println(maxSum + " "+ sum + " "+ leftMaxIndex[i-k] + " "+ i + " "+ rightMaxIndex[i+k]);
            if(maxSum<sum){
                maxSum = sum;
                res[0] = leftMaxIndex[i-k];
                res[1] = i;
                res[2] = rightMaxIndex[i+k];
            }

        }
        return res;
    }


}
