package code.hard;
import code.TreeNode;

public class LCA_BinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(root.val == p.val || root.val == q.val){
            return root;
        }
        if(left!=null && right!=null) return root;
        if(left!= null) return left;
        if(right!= null) return right;
        return null;
    }
}
