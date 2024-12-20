package code.hard;

import code.Node;

import java.util.ArrayList;
import java.util.List;

public class RootToNodePath {
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        // code here
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if(root  == null){
            return lists;
        }
        getPaths(root, list, lists);
        return lists;
    }

    public static void getPaths(Node root, List<Integer> list, ArrayList<ArrayList<Integer>> lists){
        if(root == null){
            return;
        }
        list.add(root.data);
        if(root.left == null && root.right == null){
            lists.add(new ArrayList<>(list));
        }else{
            getPaths(root.left, list, lists);
            getPaths(root.right, list, lists);
        }
        list.remove(list.size() - 1);

    }

}
