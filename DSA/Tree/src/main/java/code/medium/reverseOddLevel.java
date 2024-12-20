package code.medium;

import code.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class reverseOddLevel {
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> list = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node);
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
            if(level%2==1){
                int start = 0;
                int end = list.size()-1;
                while(start<end){
                    int temp = list.get(start).val;
                    list.get(start).val = list.get(end).val;
                    list.get(end).val = temp;
                    start++;
                    end--;
                }
            }
            level++;
        }
        return root;
    }
}
