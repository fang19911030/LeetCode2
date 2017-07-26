public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode cur = head;
        while(cur != null){
            RandomListNode t = new RandomListNode(cur.label);
            map.put(cur,t);
            cur = cur.next;
        }
        
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode cur2 = dummy;
        cur = head;
        while(cur != null){
            cur2.next = map.get(cur);
            cur2 = cur2.next;
            cur2.next = map.get(cur.next);
            cur2.random = map.get(cur.random);
            cur = cur.next;
        }
        return dummy.next;
    }

    public RandomListNode copyRandomList2(RandomListNode head){
        RandomListNode iter = head, next;
        while(iter != null){
            next = iter.next;
            RandomListNode copy = new RandomListNode(iter.label);
            iter.next = copy;
            copy.next = next;
            iter = next;
        }

        iter = head;
        while( iter != null){
            if( iter.random != null){
                iter.next.random = iter.random;
            }
            iter = iter.next.next;
        }

        iter = head;
        RandomListNode pseudoHead = new RandomListNode(0);
        RandomListNode copy, copyIter = pseudoHead;
        while(iter != null){
            next = iter.next.next;
            copy = iter.next;
            copyIter.next = copy;
            copyIter = copy;
            iter.next = next;
            iter = next;
        }
        return pseudoHead.next;
    }
}