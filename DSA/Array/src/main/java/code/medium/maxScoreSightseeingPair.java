package code.medium;

public class maxScoreSightseeingPair {
    public int maxScoreSightseeingPair(int[] values) {
        int len = values.length;
        int[] iPrefix = new int[len-1];
        int[] jPrefix = new int[len];
        iPrefix[0] = values[0] + 0;
        jPrefix[len-1] = values[len-1] - (len-1);
        for(int i = 1;i<len-1;i++){
            int j = len-1-i;
            iPrefix[i] = Math.max(iPrefix[i-1], values[i] + i);
            jPrefix[j] = Math.max(jPrefix[j+1], values[j] - j);
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<len-1;i++){
            max = Math.max(max, iPrefix[i] + jPrefix[i+1]);
        }
        return max;
    }
}
