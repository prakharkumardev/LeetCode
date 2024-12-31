package code.important;

public class maximumAbsoluteDiffrence {
    public int maxArr(int[] A) {
        int len = A.length;
        int [] plusI = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        int [] minusI = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};

        int ans = Integer.MIN_VALUE;
        for(int i = 0;i<len;i++){
            plusI[0] = Math.min(plusI[0], A[i]+i);
            plusI[1] = Math.max(plusI[1], A[i]+i);
            minusI[0] = Math.min(minusI[0], A[i]-i);
            minusI[1] = Math.max(minusI[1], A[i]-i);
        }
        ans = Math.max(ans, plusI[1] - plusI[0]);
        ans = Math.max(ans, minusI[1] - minusI[0]);
        return ans;
    }
}
