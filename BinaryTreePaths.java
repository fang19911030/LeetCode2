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
     * @param root the root of the binary tree
     * @return all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        // Write your code here
        
        List<String> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        help(root,String.valueOf(root.val),res);
        return res;
    }
    
    private void help(TreeNode node,String path,List<String> res){
        if(node == null){
            return;
        }
        if(node.left == null && node.right== null){
            res.add(path);
            return;
        }
        
        if(node.left != null){
            help(node.left,path+"->"+String.valueOf(node.left.val),res);
        }
        
        if(node.right != null){
            help(node.right, path+"->"+String.valueOf(node.right.val),res);
        }
    }
}