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
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m , int n) {
        // write your code
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = null, cur=dummy;
        int i=1;
        for(;i<=m;i++){
            pre = cur;
            cur = cur.next;
        }
        pre.next = null;
        ListNode left = cur;
        ListNode next = null;
        for(;i<=n && cur != null;i++){
            cur = cur.next;
        }
        next = cur == null? null:cur.next;
        cur.next = null;
        left = reverse(left);
        pre.next = left;
        pre = null;
        cur = dummy;
        while(cur != null){
            pre = cur;
            cur = cur.next;
        }
        pre.next = next;
        return dummy.next;
        
    }
    
    private ListNode reverse(ListNode n){
        ListNode pre = null;
        ListNode cur = n;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummyhead = new ListNode(0);
        dummyhead.next = head;
        ListNode sublisthead = new ListNode(0);
        ListNode sublisttail = new ListNode(0);
        int count = 1;
        ListNode pre_cur = dummyhead, cur = head;
        while(count <=n){
            ListNode temp = cur.next;
            if (count < m)
                pre_cur = cur;
            else if (count == m){
                sublisttail = cur;
                sublisthead.next = cur;
            }else if (count > m){
                cur.next = sublisthead.next;
                sublisthead.next = cur;
            }
            cur = temp;
            ++count;
        }
        pre_cur.next = sublisthead.next;
        sublisttail.next = cur;
        return dummyhead.next;
    }
}