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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        while(root != null){
            if(isLeaf(root)){
                List<Integer> list = new ArrayList<>();
                list.add(root.val);
                res.add(list);
                root = null;
                break;
            }
            List<Integer> list = new ArrayList<>();
            findLeaf(root, list);
            res.add(list);

        }
        
        return res;
    }
    
    private boolean findLeaf(TreeNode node, List<Integer>list){
        if(isLeaf(node)){
            if(node!=null){
                list.add(node.val);
            }
            return true;
        }
        
        boolean l = findLeaf(node.left, list);
        if(l == true) node.left = null;
        boolean r = findLeaf(node.right, list);
        if(r == true) node.right = null;
        return false;
    }
    
    private boolean isLeaf(TreeNode node){
        if(node == null){
            return true;
        }
        
        if(node.left == null && node.right == null){
            return true;
        }
        return false;
    }
}