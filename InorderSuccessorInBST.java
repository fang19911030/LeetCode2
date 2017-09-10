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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        List<TreeNode> inorder = new ArrayList<>();
        getInorder(root, inorder);
        int index = binarySearch(inorder, p);
        if(index == inorder.size()-1 || index == -1){
            return null;
        }
        return inorder.get(index+1);
    }
    
    private void getInorder(TreeNode root, List<TreeNode> inorder){
        if(root == null){
            return;
        }
        getInorder(root.left, inorder);
        inorder.add(root);
        getInorder(root.right, inorder);
    }
    
    
    private int binarySearch(List<TreeNode> inorder, TreeNode p){
        int l = 0;
        int r = inorder.size()-1;
        while(l<=r){
            int mid = l + ((r-l)>>1);
            TreeNode t = inorder.get(mid);
            if(t.val == p.val){
                return mid;
            }else if(t.val > p.val){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return -1;
    }
    
    
}