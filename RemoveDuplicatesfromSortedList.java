/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of linked list
     */
    public static ListNode deleteDuplicates(ListNode head) { 
        // write your code here
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(Integer.MAX_VALUE);
        dummy.next = head;
        ListNode pre = head;
        ListNode cur = head.next;
        while ( cur != null){
            if(pre.val == cur.val){
                pre.next = cur.next;
                cur = cur.next;
            }else{
                pre = cur;
                cur = cur.next;
            }
        }
        return dummy.next;
        
        
    }  
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next==null) return head;
        
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            while(next != null && cur.val == next.val){
                next = next.next;
            }
            cur.next = next;
            cur = cur.next;
        }
        return head;
    }
}