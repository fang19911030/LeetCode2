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
    int res = 0;
    public int countUnivalSubtrees(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        help(root);
        return res;
    }
    
    private boolean help(TreeNode root){
        if(root.left == null && root.right == null){
            res ++;
            return true;
        }else if(root.left != null && root.right != null){
            boolean left = help(root.left);
            boolean right = help(root.right);
            if(left == false || right == false){
                return false;
            }else{
                if(root.val == root.left.val && root.val == root.right.val){
                    res ++;
                    return true;
                }else{
                    return false;
                }
            }
        }else if(root.left != null){
            boolean left = help(root.left);
            if(left == false){
                return false;
            }else{
                if(root.val == root.left.val){
                    res++;
                    return true;
                }else{
                    return false;
                }
            }
        }else{
            boolean right = help(root.right);
            if(right == false){
                return false;
            }else{
                if(root.val == root.right.val){
                    res++;
                    return true;
                }else{
                    return false;
                }
            }
        }

        
    }
}