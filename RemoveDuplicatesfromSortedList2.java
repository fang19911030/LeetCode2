/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public static ListNode deleteDuplicates(ListNode head) {
        // write your code here
        ListNode dummy = new ListNode(Integer.MAX_VALUE);
        if(head == null){
            return null;
        }        
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while( cur != null){
            ListNode next = cur.next;
            if( next != null && next.val == cur.val){
                while(next != null && next.val == cur.val){
                    next = next.next;
                }
                pre.next = next;
                cur = next;
            }else{
                pre = cur;
                cur = next;
            }
        }
        return dummy.next;
        
    }
}