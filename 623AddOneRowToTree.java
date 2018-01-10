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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        return help(root, v, d, 1, null);
    }
    
    public TreeNode help(TreeNode node, int v, int d, int curd, TreeNode pre){
        if(d == 1){
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = node;
            return newRoot;
        }
        
        if(curd == d){
            TreeNode newNode = new TreeNode(v);
            if(node == pre.left){
                pre.left = newNode;
                newNode.left = node;
            }else{
                pre.right = newNode;
                newNode.right = node;
            }
            return newNode;
        }
        if(node == null){
            return node;
        }
        node.left = help(node.left, v, d, curd+1, node);
        node.right = help(node.right,v, d, curd+1, node);
        return node;
        
        
    }
}