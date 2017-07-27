public class Solution {
    /**
     * @param head a ListNode
     * @oaram v1 an integer
     * @param v2 an integer
     * @return a new head of singly-linked list
     */
    public ListNode swapNodes(ListNode head, int v1, int v2) {
        // Write your code here
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur1 = null, pre1 = null;
        ListNode cur2 = null, pre2 = null;
        ListNode cur = head;
        ListNode pre = dummy;
        while(cur != null){
            if(cur.val == v1){
                cur1 = cur;
                pre1 = pre;
            }
            if(cur.val == v2){
                cur2 = cur;
                pre2 = pre;
            }
            if(cur1 != null && cur2 != null) break;
            pre = cur;
            cur = cur.next;
        }
        if(cur1 == null || cur2 == null){
            return head;
        }
        if(pre1!= cur2 && pre2 != cur1) {
            ListNode next2 = cur2.next;
            cur2.next = cur1.next;
            pre1.next = cur2;
            pre2.next = cur1;
            cur1.next = next2;
        }else if(cur1.next == cur2){
            pre1.next = cur2;
            cur1.next = cur2.next;
            cur2.next = cur1;
        }else if(cur2.next == cur1){
            cur2.next = cur1.next;
            pre2.next = cur1;
            cur1.next = cur2;
        }
        return dummy.next;
    }
}