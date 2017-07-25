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
     * @param x: an integer
     * @return: a ListNode 
     */
    public ListNode partition(ListNode head, int x) {
        // write your code here
        ListNode small = new ListNode(0);
        ListNode bigger = new ListNode(Integer.MAX_VALUE);
        ListNode curSmall = small;
        ListNode curLarge = bigger;
        ListNode cur = head;
        while(cur != null){
            if(cur.val<x){
                curSmall.next = cur;
                curSmall = curSmall.next;
                cur = cur.next;
            }else{
                curLarge.next = cur;
                curLarge = curLarge.next;
                cur = cur.next;
            }
        }
        curLarge.next = null      // Here is very important
        curSmall.next = bigger.next;
        return small.next;
        
    }
}