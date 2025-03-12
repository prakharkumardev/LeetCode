package code.easy;

import java.lang.reflect.Array;
import java.util.Arrays;

public class NumberOfProvince {
    public int findCircleNum(int[][] isConnected) {
        int count  = 0;
        int[] visitedNode = new int[isConnected.length];
        Arrays.fill(visitedNode, -1);

        for(int i = 1 ;i<=visitedNode.length;i++){
            if(visitedNode[i-1] == -1){
                dfs(i-1, isConnected, visitedNode);
                count++;
            }
        }

        return count;
    }
    public void dfs(int node, int [][] arr, int[] visitedNode){
        if(visitedNode[node] != -1){
            return;
        }
        visitedNode[node] = 1;
        for(int i = 0;i<arr[node].length;i++){
            if(arr[node][i] == 1){
                dfs(i, arr, visitedNode);
            }
        }
    }
}
