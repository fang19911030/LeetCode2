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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 0;
        }
        
        int diameterOfLeft = diameterOfBinaryTree(root.left);
        int diameterOfRight = diameterOfBinaryTree(root.right);
        int longestPathThroughRoot = getMaxDistance(root.left)+getMaxDistance(root.right);      //node number -1 
        return Math.max(diameterOfLeft,Math.max(diameterOfRight,longestPathThroughRoot));
        
    }
    
    private int getMaxDistance(TreeNode root){           //count the number of nodes belong that path.
        if(root == null ){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        
        int left = 1+ getMaxDistance(root.left);
        int right = 1+getMaxDistance(root.right);
        return Math.max(left,right);
    }
}