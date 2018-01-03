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
    public int rob(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        return help(root, false);
    }
    
    private int help(TreeNode node, boolean pre){
        if(node == null){
            return 0;
        }
        
        if(pre==false){
            return Math.max(node.val+help(node.left, true)+help(node.right,true), help(node.left,false)+help(node.right, false));
        }else{
            return help(node.right,false)+help(node.left, false);
        }
    }
}