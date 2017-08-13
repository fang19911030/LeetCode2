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
     * @param A: an integer array
     * @return: a tree node
     */
    public TreeNode sortedArrayToBST(int[] A) {  
        // write your code here
        if(A == null || A.length==0){
            return null;
        }
        TreeNode root = buildTree(A,0,A.length-1);
        return root;
    }
    
    private TreeNode buildTree(int[]A, int left, int right){
        if(left==right){
            TreeNode node = new TreeNode(A[left]);
            return node;
        }
        if(left>right){
            return null;
        }
        
        int mid = left+(right-left)/2;
        TreeNode root = new TreeNode(A[mid]);
        root.left = buildTree(A,left,mid-1);
        root.right = buildTree(A,mid+1,right);
        return root;
    }
}
