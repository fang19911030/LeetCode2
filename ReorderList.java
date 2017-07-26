/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param head: The head of linked list.
     * @return: void
     */
    public void reorderList(ListNode head) {  
        // write your code here
        if( head == null || head.next == null){
            return;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode right = slow.next;
        slow.next = null;
        slow = head;
        right = reverse(right);
        while( slow!= null && right != null){
            ListNode next = slow.next;
            ListNode next2 = right.next;
            slow.next = right;
            right.next = next;
            slow = next;
            right = next2;
        }
    }
    
    private ListNode reverse(ListNode head){
        ListNode cur=head, pre=null;
        while(cur != null){
            ListNode next= cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
        
    }
}
