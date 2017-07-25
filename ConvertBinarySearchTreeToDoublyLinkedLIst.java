/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 * Definition for Doubly-ListNode.
 * public class DoublyListNode {
 *     int val;
 *     DoublyListNode next, prev;
 *     DoublyListNode(int val) {
 *         this.val = val;
 *         this.next = this.prev = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param root: The root of tree
     * @return: the head of doubly list node
     */
    public DoublyListNode bstToDoublyList(TreeNode root) {
        if(root == null){
            return null;
        }
        List<Integer> list = new LinkedList<>();
        getInorder(root, list);
        DoublyListNode dummy = new DoublyListNode(0);
        DoublyListNode cur = dummy;
        DoublyListNode pre = null;
        for(int i=0;i<list.size();i++){
            DoublyListNode tmp = new DoublyListNode(list.get(i));
            cur.next = tmp;
            cur = cur.next;
            cur.prev = pre;
            pre = cur;
        }
        return dummy.next;
    }
    
    private void getInorder(TreeNode node, List<Integer> list){
        if(node == null){
            return;
        }
        getInorder(node.left,list);
        list.add(node.val);
        getInorder(node.right,list);
    }
}