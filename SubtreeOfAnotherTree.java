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
        if(s == null){
            return t==null;
        }
        if(t == null){
            return s==null;
        }
        if(isIdentical(s,t)){
            return true;
        }
        
        boolean left = isSubtree(s.left, t);
        boolean right = isSubtree(s.right, t);
        return left || right;
    }
    
    private boolean isIdentical(TreeNode s, TreeNode t){
        if(s== null && t == null){
            return true;
        }
        
        if( s == null){
            return t == null;
        }
        
        if(t == null){
            return s == null;
        }
        
        if(s.val != t.val){
            return false;
        }
        
        if((s.left != null && s.right != null) || (t.left != null && t.right!= null)){
            return isIdentical(s.right,t.right) & isIdentical(s.left,t.left);
        }else if((s.left == null && s.right != null) || (t.left== null && t.right != null)){
            return isIdentical(s.right, t.right);
        }else if((s.right == null && s.left != null) || (t.right == null && t.left != null)){
            return isIdentical(s.left, t.left);
        }
        return true;
    }
}