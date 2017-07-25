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
     * @param head: The first node of linked list.
     * @param n: An integer.
     * @return: The head of linked list.
     */
    ListNode removeNthFromEnd(ListNode head, int n) {
        // write your code here
        
        ListNode h1 = reverse(head);
        ListNode h2 = remove(h1,n);
        return reverse(h2);
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
    
    private ListNode remove(ListNode head, int n){
        ListNode help = new ListNode(0);
        help.next = head;
        ListNode cur = help;
        for(int i=1;i<n;i++){
            cur = cur.next;
        }
        
        cur.next = cur.next.next;
        return help.next;
    }
}