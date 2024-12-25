package code.medium;

import code.TreeNode;

import java.util.*;

public class minimumOperation {
    public int minimumOperations(TreeNode root) {
        int count = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            count += getSwipes(list);
        }
        return count;
    }
    private int getSwipes(List<Integer> list) {
        int count = 0;
        List<Integer> sortedList = new ArrayList<>(list);
        Collections.sort(sortedList);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            map.put(map.get(i), i);
        }
        int s = 0;
        while(s<sortedList.size()) {
            if(list.get(s)==sortedList.get(s)) {
                s++;
                continue;
            }else{
                //get correct index of the value present in the sorted array a
                int index = map.get(sortedList.get(s));
                int temp = list.get(s);
                list.set(index, temp);
                list.set(s,index);
                s++;
                count++;
            }
        }
        return count;
    }
}
