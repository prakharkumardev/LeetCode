package code.easy;

import code.ListNode;

import java.util.*;

public class reverseLLRecursively {
    class Pair{
        ListNode head;
        ListNode tail;
        Pair(ListNode head,ListNode tail){
            this.head = head;
            this.tail = tail;
        }
        void setTail(ListNode tail){
            this.tail = tail;
        }
        void setHead(ListNode head){
            this.head = head;
        }
        ListNode getTail(){
            return this.tail;
        }
        ListNode getHead(){
            return this.head;
        }

    }
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        Pair p = reverseListHelper(head);
        return p.getHead();
    }

    public Pair reverseListHelper(ListNode head){
        if(head.next == null){
            return new Pair(head,head);
        }
        Pair p = reverseListHelper(head.next);
        p.getTail().next = head;
        head.next = null;
        p.setTail(head);
        return new Pair(p.getHead(),head);
    }







    public List<String> stringMatching(String[] words) {

        List<String> str = new ArrayList<>(Arrays.asList(words));
        List<String> ans = new ArrayList<>();
        str.sort((a,b)->a.length()-b.length());
        for(int i = 0; i<str.size();i++){
            for(int j = i+1;j<str.size();j++){
                if(str.get(j).contains(str.get(i))){
                    ans.add(str.get(i));
                    break;
                }
            }
        }
        return ans;



    }














}
