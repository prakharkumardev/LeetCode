package code.medium;


import code.TreeNode;

import java.util.HashSet;
import java.util.Set;

class FindElements {
    private final Set<Integer> set = new HashSet<>();
    public FindElements(TreeNode root) {
        root.val = 0;
        recoverTree(root);
    }
    private void recoverTree(TreeNode node){
        if(node == null) return;
        if(node.left!= null){
            node.left.val = node.val*2 + 1;
            set.add(node.left.val);
            recoverTree(node.left);
        }
        if(node.right!= null){
            node.right.val = node.val*2 + 2;
            set.add(node.right.val);
            recoverTree(node.right);
        }
    }

    public boolean find(int target) {
        return set.contains(target);
    }
}