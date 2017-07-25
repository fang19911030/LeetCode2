public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        // Write your code here
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        ListNode next = head.next;
        while(cur != null && next != null){
            ListNode tmp = next.next;
            pre.next = next;
            next.next = cur;
            cur.next = tmp;
            pre = cur;
            cur = tmp;
            next = cur == null? null: cur.next;
        }
        return dummy.next;
    }
}