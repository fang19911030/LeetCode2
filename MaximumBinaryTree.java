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
    class SegmentNode{
        int left;
        int right;
        SegmentNode l;
        SegmentNode r;
        int max;
        SegmentNode(int left, int right){
            this.left = left;
            this.right = right;
        }
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }
        SegmentNode segRoot = buildSegmentTree(nums,0,nums.length-1);
        TreeNode root = buildTree( nums,0,nums.length-1,segRoot);
        return root;
    }
    
    private TreeNode buildTree(int[] nums, int l, int r, SegmentNode segRoot){
        int index = maxQuery(segRoot,l,r,nums);
        if(index<0 || index>=nums.length){
            return null;
        }
        TreeNode root = new TreeNode(nums[index]);
        root.left = buildTree(nums,l,index-1,segRoot);
        root.right = buildTree(nums,index+1,r, segRoot);
        return root;
    }
    
    
    private int maxQuery(SegmentNode root, int l, int r,int[]nums){
        if(root == null){
            return -1;
        }
        
        if(root.left == l && root.right == r){
            return root.max;
        }
        
        int mid = root.left + (root.right - root.left)/2;
        if(r<=mid){
            return maxQuery(root.l,l,r,nums);
        }else if(l>mid){
            return maxQuery(root.r,l,r,nums);
        }else{
            int indexL = maxQuery(root.l,l,mid, nums);
            int indexR = maxQuery(root.r,mid+1,r, nums);
            if(nums[indexL]>nums[indexR]){
                return indexL;
            }
            return indexR;
        }
    }
    
    private SegmentNode buildSegmentTree(int[] nums, int l, int r){
        if(l>r){
            return null;
        }
        if(l == r){
            SegmentNode node = new SegmentNode(l,r);
            node.max = l;
            return node;
        }
        
        int mid = l +(r-l)/2;
        SegmentNode node = new SegmentNode(l,r);
        node.l = buildSegmentTree(nums,l,mid);
        node.r = buildSegmentTree(nums,mid+1,r);
        if(node.l != null && node.r != null){
            node.max = nums[node.l.max]>nums[node.r.max]?  node.l.max:node.r.max;
        }
        return node;
    }
}