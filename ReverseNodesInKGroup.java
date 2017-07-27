public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // Write your code here
        if(head == null ){
            return head;
        }
        int length = getLength(head);
        if(k > length ){
            return head;
        }
        ListNode[] heads = length%k==0? new ListNode[length/k]:new ListNode[length/k+1];
        ListNode cur = head;
        ListNode sub = cur;
        for(int i=0;i<heads.length-1;i++){
            ListNode subcur = sub;
            for(int j=1;j<k;j++){
                subcur = subcur.next;
            }
            heads[i] = sub;
            sub = subcur.next;
            subcur.next = null;
        }
        heads[heads.length-1] = sub;
        int tail = length%k==0? 0:1;
        for(int i=0;i<heads.length-tail;i++){
            heads[i] = reverse(heads[i]);
        }
        ListNode dummy = new ListNode(0);
        cur = dummy;
        for(int i=0;i<heads.length;i++){
            ListNode subhead = heads[i];
            cur.next = subhead;
            while(cur.next!=null){
                cur = cur.next;
            }
        }
        return dummy.next;
    }
    
    private int getLength(ListNode head){
        int res = 0;
        ListNode cur = head;
        while(cur != null){
            cur = cur.next;
            res++;
        }
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