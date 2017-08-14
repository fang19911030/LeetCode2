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
 */


public class Solution {
    /*
     * @param T1: The roots of binary tree T1.
     * @param T2: The roots of binary tree T2.
     * @return: True if T2 is a subtree of T1, or false.
     */
    
    public boolean isSubtree(TreeNode T1, TreeNode T2) {
        boolean res = false;
        if(T1 != null && T2 != null){
            if(isIdentical(T1,T2)){
                res=true;
            }else{
                if(isSubtree(T1.left, T2)){
                    res= true;
                }else if(isSubtree(T1.right, T2)){
                    res = true;
                }
                return res;
            }
        }else if(T1 == null && T2 != null){
            return false;
        }else{
            res=true;
        }
        return res;
    }
    
    private boolean isIdentical(TreeNode n1, TreeNode n2){
        if(n1!= null && n2!= null){
            if(n1.val == n2.val){
                boolean left = isIdentical(n1.left, n2.left);
                boolean right = isIdentical(n1.right, n2.right);
                return left &&right;
            }else{
                return false;
            }
        }else if(n1 == null && n2 == null){
            return true;
        }else{
            return false;
        }
    }
    
};