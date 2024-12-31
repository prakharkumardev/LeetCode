package code.medium;

import java.util.Arrays;

public class paintHouseMinCost {
    public int minCost(int[][] costs) {
        int[] minArr = new int[3];
        minArr = costs[0];
        System.out.println(Arrays.toString(minArr));
        for(int i = 1;i<costs.length-1;i++){
            int[] temp = new int[3];
            temp[0] = costs[i][0] + Math.min(minArr[1],minArr[2]);
            temp[1] = costs[i][1] + Math.min(minArr[0],minArr[2]);
            temp[2] = costs[i][2] + Math.min(minArr[0],minArr[1]);
            System.out.println(Arrays.toString(temp));
            minArr = temp;

        }
        return Math.min(minArr[0],Math.min(minArr[1],minArr[2]));
    }

}
