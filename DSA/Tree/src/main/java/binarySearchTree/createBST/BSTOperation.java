package binarySearchTree.createBST;

public class BSTOperation {
    private TreeNode root;
    BSTOperation(){
        root = null;
    }

    public void addNode(int value){
        TreeNode node = new TreeNode(value, null, null);
        if(root == null){
            root = node;
        }else{
            addNewNode(node, root);
        }
    }
    private void addNewNode(TreeNode node, TreeNode root){
        if(node.getValue() > root.getValue()){
            if(root.getRight() == null) root.setRight(node);
            else addNewNode(node, root.getRight());
        }else{
            if(root.getLeft() == null) root.setLeft(node);
            else addNewNode(node, root.getLeft());
        }
    }

    public boolean isValuePresent(int value){
        return isPresent(value, root);
    }
    private boolean isPresent(int value, TreeNode root){
        if(root == null) return false;
        if(value == root.getValue()) return true;
        if(value > root.getValue()){
            return isPresent(value, root.getRight());
        }else{
            return isPresent(value, root.getLeft());
        }
    }

    private void printPostOrder(TreeNode node){
        if(node == null) return;
        printPostOrder(node.getLeft());
        System.out.println(node.getValue());
        printPostOrder(node.getRight());
    }

    public void deleteNode(int value) throws Exception {

        if(!isPresent(value, root)) {
            // throw exception
            Exception exception = new RuntimeException("Value not present");
            throw exception;
        }
        delete(value, root);

    }
    private void delete(int value, TreeNode node){
        if(value == node.getValue()){

        }
    }
   @Override
    public String toString(){
        printPostOrder(root);
        return "";
   }

}
