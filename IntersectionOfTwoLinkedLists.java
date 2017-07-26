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
     * @param headA: the first list
     * @param headB: the second list
     * @return: a ListNode 
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Write your code here
        
        Set<ListNode> set = new HashSet<>();
        ListNode cur = headA;
        while(cur != null){
            set.add(cur);
            cur = cur.next;
        }
        cur = headB;
        while(cur != null){
            if(!set.add(cur)){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }
    
    
}