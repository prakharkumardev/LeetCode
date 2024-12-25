
import code.ListNode;

public ListNode reverseList(ListNode head) {


}

private ListNode reverseLLIteratively(ListNode head) {
    ListNode current = head;
    ListNode left = null;
    ListNode right = null;
    while (current != null) {
        right = current.next;
        current.next = left;
        left = current;
        current = right;
    }
    return left;
}


private ListNode reverseLLRecursive(ListNode head , ListNode){



}
