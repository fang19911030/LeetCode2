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
    public int closestValue(TreeNode root, double target) {
        if(target> root.val){
            return help(root.right, target, root.val);
        }else{
            return help(root.left, target, root.val);
        }
    }
    
    private int help(TreeNode node, double target, int pre){
        if(node == null){
            return pre;
        }
        double diff2 = Double.MAX_VALUE;
        double diff1 = Math.abs(target-pre);
        int candidate = 0;
        
        if(target<node.val ){
            candidate = help(node.left, target, node.val);
            diff2 = Math.abs(candidate-target);
        }else{
            candidate = help(node.right, target, node.val);
            diff2 = Math.abs(candidate-target);
        }
        
        
        if(diff2 < diff1){
            return candidate;
        }else{
            return pre;
        }
        
    }
}