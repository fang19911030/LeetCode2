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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode root = merge(t1, t2);
        return root;
    }
    
    private TreeNode merge(TreeNode t1, TreeNode t2){
        if(t1 == null && t2 == null){
            return null;
        }
        TreeNode node = null;
        if(t1 != null && t2 != null){
             node = new TreeNode(t1.val + t2.val);
            node.left = merge(t1.left, t2.left);
            node.right = merge(t1.right, t2.right);
        }
        if(t2 == null){
            node = new TreeNode(t1.val); 
            node.left = merge(t1.left,null);
            node.right = merge(t1.right,null);
        }
        
        if(t1 == null){
            node = new TreeNode(t2.val);
            node.left = merge(null,t2.left);
            node.right = merge(null, t2.right);
        }
        return node;
    }
}