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
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {  
        // write your code here
        if(lists.size()==0){
            return null;
        }
        Comparator<ListNode> cmp = new Comparator<ListNode>(){
            @Override
            public int compare(ListNode a, ListNode b){
                return a.val-b.val;
            }
        };
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.size(),cmp);
        for(int i=0;i<lists.size();i++){
            if(lists.get(i) != null){                           //Here is the Key part
                pq.offer(lists.get(i));
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(pq.size()>0){
            ListNode small = pq.poll();
            ListNode next = small.next;
            cur.next = small;
            cur = cur.next;
            small.next = null;
            if(next != null){
                pq.offer(next);
            }
        }
        return dummy.next;
    }
}