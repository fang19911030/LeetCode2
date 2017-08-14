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
     * @param root: a TreeNode, the root of the binary tree
     * @return: 
     */
    public void flatten(TreeNode root) {
        // write your code here
        List<TreeNode> list = new ArrayList<>();
        getNodes(root,list);
        for(int i=0;i<list.size()-1;i++){
            TreeNode pre = list.get(i);
            pre.right = list.get(i+1);
            pre.left = null;
        }
        
    }
    
    private void getNodes(TreeNode root, List<TreeNode> list){
        if(root == null){
            return;
        }
        
        list.add(root);
        getNodes(root.left,list);
        getNodes(root.right, list);
    }
};