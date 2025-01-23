package binarySearchTree.createBST;

public class TreeNode {
    private int value;
    private TreeNode left;
    private TreeNode right;
    TreeNode(int value, TreeNode left, TreeNode right){
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
