package code.hard;

import code.ListNode;

import java.util.List;

public class reverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        int len = 0;
        ListNode temp = head;
        while(temp!=null && len<k){
            len++;
            temp = temp.next;
        }
        if(len<k) return head;
        ListNode left = null;
        ListNode right = null;
        ListNode current = head;
        int count  = 0;
        while(current != null && count<k){
            right = current.next;
            current.next = left;
            left = current;
            current = right;
            count++;
        }
        if(right!=null){
            head.next = reverseKGroup(right,k);
        }
        return left;
    }
}
