package code.medium;

public class productExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] lpro = new int[len];
        int[] rpro = new int[len];
        lpro[0] = nums[0];
        rpro[len-1] = nums[len-1];
        for(int i = 1 ;i<len;i++){
            int j = len -1 - i;
            lpro[i] = lpro[i-1] * nums[i];
            rpro[j] = rpro[j+1] * nums[j];
        }

        for(int i = 0;i<len;i++){
            if(i == 0){
                nums[i] = rpro[i+1];
            }else if(i == len-1){
                nums[i] = lpro[i-1];
            }else{
                nums[i] = lpro[i-1] * rpro[i+1];
            }
        }
        return nums;
    }
}
