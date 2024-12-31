package code.hard;

import java.util.Arrays;

public class paintHouse2 {
    public int minCostII(int[][] costs) {
        int len = costs[0].length;
        int[] minCost = new int[costs[0].length];
        minCost = costs[0];
        for(int i = 1;i<costs.length;i++){
            int[] temp = new int[len];
            for(int j=0;j<len;j++){
                temp[j] = costs[i][j] + getMin(costs[i], j);
            }
            minCost = temp;
        }
        System.out.println(Arrays.toString(minCost));
        return Math.min(getMin(minCost,0), minCost[0]);
    }
    private int getMin(int[] arr, int index){
        int min = Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            if(i == index) continue;
            min = Math.min(min, arr[i]);
        }
        return min;
    }
}
