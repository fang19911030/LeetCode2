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
    public int maxPathSum(TreeNode root) {
        if(root == null ){
            return Integer.MIN_VALUE;
        }
        
        if(root.left == null && root.right == null){
            return root.val;
        }
        
        int sum = root.val;
        sum += getSum(root.left)>0? getSum(root.left):0;
        sum += getSum(root.right)>0? getSum(root.right):0;
        int left = maxPathSum(root.left);
        int right = maxPathSum(root.right);
        return Math.max(sum, Math.max(left, right));
    }
    
    private int getSum(TreeNode root){
        if(root == null){
            return 0;
        }
        
        if(root.left == null && root.right == null){
            return root.val;
        }
        
        int val = root.val;
        int l = getSum(root.left);
        int r = getSum(root.right);
        int max = Math.max(l, r);
        if(max<0){
            return val;
        }
        return max+val;
    }
}

class Solution {
    public int maxPathSum(TreeNode root) {
        if (root == null){
            return 0;
        }
        int[] res = new int[1];
        res[0] = Integer.MIN_VALUE;
        maxPathDown(root, res);
        return res[0];
    }
    
    private int maxPathDown(TreeNode node, int[] res){
        if(node == null) return 0;
        int left = Math.max(0, maxPathDown(node.left,res));
        int right = Math.max(0, maxPathDown(node.right, res));
        res[0] = Math.max(res[0], left + right+node.val);
        return Math.max(left,right) + node.val;
    }
}