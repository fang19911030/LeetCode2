/**
 * Definition for singly-linked list.
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
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2 
     */
    public ListNode addLists2(ListNode l1, ListNode l2) {
        // write your code here
        ListNode h1 = reverse(l1);
        ListNode h2 = reverse(l2);
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int carry = 0;
        while( h1 != null || h2 != null){
            if(h1 != null && h2 != null){
                int res = h1.val + h2.val + carry;
                cur.next = new ListNode(res%10);
                carry = res/10;
                cur = cur.next;
                h1 = h1.next;
                h2 = h2.next;
            }else if( h1 != null){
                int res = h1.val + carry;
                cur.next = new ListNode(res%10);
                carry = res/10;
                cur = cur.next;
                h1 = h1.next;
            }else{
                int res = h2.val + carry;
                cur.next = new ListNode(res%10);
                carry = res/10;
                cur = cur.next;
                h2 = h2.next;
            }
        }
        if( carry == 1){
            cur.next = new ListNode(1);
        }else{
            cur.next = null;
        }
        ListNode res = reverse(dummy.next);
        return res;
        
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