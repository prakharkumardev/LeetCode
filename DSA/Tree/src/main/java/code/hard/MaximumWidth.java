package code.hard;

import code.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidth {
    public class Pair{
        TreeNode node;
        int key;
        Pair(TreeNode node, int key){
            this.node = node;
            this.key = key;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int width = 0;
        Queue<Pair> q= new LinkedList<>();
        q.add(new Pair(root,0));
        while(!q.isEmpty()){
            int size=q.size();
            int min = q.peek().key;
            int first = 0, last = 0;
            for(int i = 0; i < size; i++){
                Pair pair = q.poll();
                TreeNode node = pair.node;
                int nodeValue = pair.key-min;
                if(node.left != null) q.add(new Pair(node.left, nodeValue*2 ));
                if(node.right != null) q.add(new Pair(node.right, nodeValue*2+1));
                if( i == 0) first = nodeValue;;
                if(i == size-1) last = nodeValue;
            }
            width = Math.max(width, last-first+1);
        }


        return width;
    }

    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int num : nums){
            sum+=num;
            max = Math.max(sum, max);
            if(sum<0) sum = 0;
            max = Math.max(sum, max);
        }
        return max;
    }
}
