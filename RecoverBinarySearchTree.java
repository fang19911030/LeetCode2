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
    public void recoverTree(TreeNode root) {
        List<TreeNode> inorder = new ArrayList<>();
        getInorder(root,inorder);
        if(inorder.size()<=1){
            return;
        }
        TreeNode first = null;
        TreeNode second = null;
        for(int i=0;i<inorder.size();i++){
            if(i == 0 ){
                 if(inorder.get(i).val > inorder.get(i+1).val) first = inorder.get(i);
            }else if(i == inorder.size()-1){
                if(inorder.get(i).val < inorder.get(i-1).val) second = inorder.get(i);
            }else{
                if(inorder.get(i).val< inorder.get(i-1).val || inorder.get(i).val > inorder.get(i+1).val){
                    if(first == null){
                        first = inorder.get(i);
                    }else{
                        second = inorder.get(i);
                    }
                }
            }
        }
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }
    
    private void getInorder(TreeNode root,List<TreeNode> inorder){
        if(root == null){
            return;
        }
        
        getInorder(root.left,inorder);
        inorder.add(root);
        getInorder(root.right,inorder);
        
    }
}