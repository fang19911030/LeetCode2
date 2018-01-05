/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null){
            return null;
        }
        if(root.left == null && root.right == null){
            return root;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while(cur != null){
            stack.push(cur);
            cur = cur.left;
        }
        
        TreeNode res = stack.pop();
        cur = res;
        while(!stack.isEmpty()){
            TreeNode next = stack.pop();
            next.left = null;
            cur.left = next.right;
            next.right = null;
            cur.right = next;
            cur = cur.right;
        }
        return res;
        
    }
    
}

class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null || root.left == null){
            return root;
        }
        
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        return newRoot;
    }
}

class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode cur = root;
        TreeNode nxt = null;
        TreeNode temp = null;
        TreeNode prev = null;
        while(cur != null){
            next = cur.left;
            
            cur.left = temp;
            temp = cur.right;
            cur.right = prev;
            
            prev = cur;
            cur = nxt;
            
        }
        return prev;
    }
}