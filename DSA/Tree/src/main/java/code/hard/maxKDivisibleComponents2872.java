package code.hard;

import java.util.*;

public class maxKDivisibleComponents2872 {
    public int count  = 0;
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < edges.length; i++){
            int key = edges[i][0];
            int value = edges[i][1];
            if(map.containsKey(key)) {
                map.get(key).add(value);
            }else {
                List<Integer> list = new ArrayList<>();
                list.add(value);
                map.put(key, list);
            }
        }
        int root = findRoot(edges);
        int rootVal = calculatePartition(map, values, k, root);
        return count;
    }
    private  int findRoot(int[][] edges) {
        // Set to track child nodes
        Set<Integer> childNodes = new HashSet<>();

        // Add all child nodes from the edges
        for (int[] edge : edges) {
            childNodes.add(edge[1]);
        }

        // Find the parent node that is not a child
        for (int[] edge : edges) {
            if (!childNodes.contains(edge[0])) {
                return edge[0]; // Root node
            }
        }
        return edges[0][0];
    }
    private int calculatePartition(Map<Integer, List<Integer>> map, int[] values, int k, int root) {
        //root check
        if(map.get(root) == null) {
            //leaf node
            if(values[root] % k == 0) {
                count++;
                System.out.println("root: " + root+ " sum: " + values[root] + " count: " + count);
                return 0;
            }else {
                System.out.println("root: " + root+ " sum: " + values[root] + " count: " + count);
                return values[root];
            }
        }
        int sum = values[root];
        List<Integer> children = map.get(root);
        for(int i = 0; i < children.size(); i++) {
            sum += calculatePartition(map, values, k, children.get(i));
        }
        if(sum % k == 0) {
            count++;
            System.out.println("root: " + root+ " sum: " + sum + " count: " + count);
            return 0;
        }else {
            System.out.println("root: " + root+ " sum: " + sum+ " count: " + count);
            return sum;
        }
    }


}
