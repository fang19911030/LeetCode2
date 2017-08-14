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
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void invertBinaryTree(TreeNode root) {
        // write your code here
        if(root == null){
            return;
        }
        invert(root);
        return;
    }
    
    private void invert(TreeNode node){
        if(node == null){
            return;
        }
        
        if(node.left != null){
            invert(node.left);
        }
        
        if(node.right != null){
            invert(node.right);
        }
        
        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;
    }
}