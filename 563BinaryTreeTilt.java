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
    public int findTilt(TreeNode root) {
        if(root == null){
            return 0;
        }
        int[] res = new int[1];
        help(root, res);
        return res[0];
    }
    
    private int help(TreeNode node, int[] res){
        if(node == null){
            return 0;
        }
        
        int leftSum = help(node.left, res);
        int rightSum = help(node.right, res);
        res[0] += (int)Math.abs(leftSum-rightSum);
        return leftSum+rightSum+node.val;
    }
}