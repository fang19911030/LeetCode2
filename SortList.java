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
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list,
     */
    public ListNode sortList(ListNode head) {  
        // write your code here
        int length = getLength(head);
        head = sort(head,0,length-1);
        return head;
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
    
    private ListNode sort(ListNode head,int left, int right){
        if(left == right){
            return head;
        }
        if(left > right){
            return null;
        }
        int mid = left + (right-left)/2;
        ListNode cur = head;
        ListNode rightHead = null;
        for(int i=left;i<mid;i++){
            cur = cur.next;
        }
        rightHead = cur.next;
        cur.next = null;
        head = sort(head,left,mid);
        rightHead = sort(rightHead,mid+1,right);
        head =merge(head, rightHead);
        return head;
    }
    
    private ListNode merge(ListNode a, ListNode b){
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(a != null || b!=null){
            if(a!= null && b != null){
                if(a.val<b.val){
                    cur.next = a;
                    a = a.next;
                    cur = cur.next;
                }else{
                    cur.next = b;
                    b = b.next;
                    cur = cur.next;
                }
            }else if (a != null){
                cur.next = a;
                a = a.next;
                cur = cur.next;
            }else{
                cur.next = b;
                b = b.next;
                cur = cur.next;
            }
        }
        return dummy.next;
        
    }
}
