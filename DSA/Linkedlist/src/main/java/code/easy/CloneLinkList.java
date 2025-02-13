package code.easy;

import java.util.HashMap;
import java.util.Map;

public class CloneLinkList {
    public static class Node{
        int value;
        Node nextNode;
        Node randomNode;
        Node(int value, Node nextNode, Node randomNode){
            this.value = value;
            this.nextNode = nextNode;
            this.randomNode = randomNode;
        }
    }


    public static Node getClone(Node root){
        if(root == null) return null;

        Map<Node, Node> mp = new HashMap<>();

        Node headNode = root;
        Node newHeadNode = null;
        Node newHeadNodeFixed = null;

        while(headNode!= null){
            if(newHeadNode == null) {
                Node node  = new Node(headNode.value, null, null);
                mp.put(headNode, node);
                newHeadNode  = node;
                newHeadNodeFixed = node;
                headNode = headNode.nextNode;
            }else{
                Node node = new Node(headNode.value, null,null);
                mp.put(headNode,node);
                newHeadNode.nextNode = node;
                newHeadNode = newHeadNode.nextNode;
                headNode = headNode.nextNode;
            }
        }
        headNode = root;
        while (headNode!=null){
            if(headNode.randomNode!=null){
                Node colenNode1 =  mp.get(headNode);
                Node cloneNode2 = mp.get(headNode.randomNode);
                colenNode1.randomNode = cloneNode2;
            }
            headNode = headNode.nextNode;
        }
        return newHeadNodeFixed;
    }

    public static void print(Node root){
        while(root!=null){
            System.out.println(root.value+" "+
                    (root.randomNode!= null ? root.randomNode.value : null)+" "+ (root.nextNode != null ? root.nextNode.value : null));
            root = root.nextNode;
        }
    }

    public static void main(String[] args) {
//        TreeNode t1 = new TreeNode(1, null,null);
//        TreeNode t2 = new TreeNode(2, null,null);
//        TreeNode t3 = new TreeNode(3, null,null);
//        TreeNode t4 = new TreeNode(4, null,null);
//        TreeNode t5 = new TreeNode(5, null,null);
//        TreeNode t6 = new TreeNode(6, null,null);
//        TreeNode t7 = new TreeNode(7, null,null);
//        TreeNode t8 = new TreeNode(8, null,null);


    }

    public static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;
        TreeNode(int value, TreeNode left, TreeNode right){
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public static int lowestAncestor(TreeNode root, int val1, int val2){
        if(root == null) return -1;
        if(root.value == val1 || root.value == val2 ){
            return root.value;
        }
        int leftval = lowestAncestor(root.left, val1, val2);
        int rightval = lowestAncestor(root.right, val1, val2);

        if(leftval!= -1 && rightval!= -1){
            return root.value;
        }
        if(leftval!= -1 || rightval!= -1){
            return leftval!=-1 ? leftval : rightval;
        }
        return -1;
    }

}
