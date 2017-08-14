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
     * @param a: the root of binary tree a.
     * @param b: the root of binary tree b.
     * @return: true if they are identical, or false.
     */
    public boolean isIdentical(TreeNode a, TreeNode b) {
        // write your code here
        if(a!= null && b!=null){
            if(a.val == b.val){
                boolean leftIdentical = isIdentical(a.left, b.left);
                boolean rightIdentical = isIdentical(a.right, b.right);
                return leftIdentical && rightIdentical;
            }else{
                return false;
            }
        }else if(a== null && b== null){
            return true;
        }else{
            return false;
        }
    }
};