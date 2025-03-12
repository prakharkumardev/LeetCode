package code.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountComponents {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0 ; i<n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        int[] visitedEdge = new int[n];
        Arrays.fill(visitedEdge, -1);
        int graphs = 0;
        for(int i = 0 ;i<=n;i++){
            if(visitedEdge[i] == -1){
                dfs(i, visitedEdge, adjList);
                graphs++;
            }
        }
        return graphs;
    }
    public void dfs(int startNode, int [] visited, List<List<Integer>> adj){
        if(visited[startNode] == -1){
            visited[startNode] = 1;
            adj.get(startNode).forEach(node -> dfs(node, visited, adj));
        }
    }
}
