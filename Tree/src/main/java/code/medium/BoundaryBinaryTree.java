package code.medium;

import code.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BoundaryBinaryTree {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        result.add(root.val);

        result.addAll(leftBoundary(root.left, new ArrayList<>()));

        result.addAll(getLeaf(root.left, new ArrayList<>()));
        result.addAll(getLeaf(root.right, new ArrayList<>()));

        List<Integer> right  = rightBoundary(root.right, new ArrayList<>());
        Collections.reverse(right);

        result.addAll(right);

        return result;
    }
    private List<Integer> leftBoundary(TreeNode root, List<Integer> list) {
        if (root == null) return list;
        if(root.left == null && root.right == null) return list;
        list.add(root.val);
        if(root.left != null) leftBoundary(root.left, list);
        else leftBoundary(root.right, list);
        return list;
    }
    private List<Integer> rightBoundary(TreeNode root, List<Integer> list) {
        if (root == null) return list;
        if(root.left == null && root.right == null) return list;
        list.add(root.val);
        if(root.right!= null) rightBoundary(root.right, list);
        else rightBoundary(root.left, list);
        return list;
    }
    private List<Integer> getLeaf(TreeNode root, List<Integer> list) {
        if (root == null) return list;
        if(root.left == null && root.right == null) list.add(root.val);
        if(root.left != null) getLeaf(root.left, list);
        if(root.right != null) getLeaf(root.right, list);
        return list;
    }
}
