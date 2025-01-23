package binarySearchTree.createBST;


public class Main {
    public static void main(String[] args) {

        BSTOperation bstOperation = new BSTOperation();

        bstOperation.addNode(50);
        bstOperation.addNode(30);
        bstOperation.addNode(70);
        bstOperation.addNode(20);
        bstOperation.addNode(40);
        bstOperation.addNode(60);
        bstOperation.addNode(80);

        System.out.println(bstOperation.isValuePresent(99));
        System.out.println(bstOperation.isValuePresent(50));

       String s = bstOperation.toString();


    }



    /*
    50 as a root note 30left 70right
    30 20 40
    70 60 80
    80
    postorder traversal
    deletion
    search

     */
}





