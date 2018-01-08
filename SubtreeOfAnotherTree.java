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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s== null){
            return t==null;
        }
        
        if(t == null){
            return s == null;
        }
        
        boolean cur = isSub(s, t);
        if(cur == true) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    
    private boolean isSub(TreeNode s, TreeNode t){
        if(s == null){
            return t==null;
        }
        
        if(t == null){
            return s==null;
        }
        if(s.val != t.val){
            return false;
        }
        return isSub(s.left, t.left) && isSub(s.right, t.right);
    }
}