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
    /**
     * @param root: The root of binary tree
     * @return root of new tree
     */
    public TreeNode cloneTree(TreeNode root) {
        // Write your code here
        TreeNode copy = cloneNode(root);
        return copy;
    }
    
    private TreeNode cloneNode(TreeNode root){
        if(root==null){
            return null;
        }
        TreeNode copy = new TreeNode(root.val);
        copy.left = cloneNode(root.left);
        copy.right = cloneNode(root.right);
        return copy;
    }
}