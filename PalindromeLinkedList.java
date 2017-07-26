/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param head a ListNode
     * @return a boolean
     */
    public boolean isPalindrome(ListNode head) {
        // Write your code here
        if(head == null || head.next == null){
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast!= null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode right = slow;                //Here is the half of the list
        right = reverse(right);
        ListNode cur = right;
        slow = head;
        while(slow != null && cur!= null){
            if(slow.val != cur.val){
                return false;
            }
            slow = slow.next;
            cur = cur.next;
        }
        return true;
    }
    
    private ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while( cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}