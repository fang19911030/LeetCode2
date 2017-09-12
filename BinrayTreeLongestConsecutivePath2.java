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
    int max = 1;
    public int longestConsecutive(TreeNode root) {
        if(root == null){
            return 0;
        }
        dfs(root);
        return max;
    }
    
    private int dfs(TreeNode p){
        if(p == null ) return 0;
        int L = dfs(p.left) + 1;
        int R = dfs(p.right) + 1;
        if(p.left != null && p.left.val-1 != p.val){
            L = 1;
        }
        if(p.right != null && p.right.val-1!=p.val){
            R = 1;
        }
        max = Math.max(max, Math.max(L,R));
        return Math.max(L, R);
        
        
    }
    
    
}