/**
 * Definition of SegmentTreeNode:
 * public class SegmentTreeNode {
 *     public int start, end, max;
 *     public SegmentTreeNode left, right;
 *     public SegmentTreeNode(int start, int end, int max) {
 *         this.start = start;
 *         this.end = end;
 *         this.max = max
 *         this.left = this.right = null;
 *     }
 * }
 */


public class Solution {
    
    /*
     * @param A: a list of integer
     * @return: The root of Segment Tree
     */
    public SegmentTreeNode build(int[] A) {
        // write your code here
        if(A== null || A.length == 0){
            return null;
        }
        SegmentTreeNode root = buildTree(A,0,A.length-1);
        return root;
    }
    
    private SegmentTreeNode buildTree(int[]A, int l, int r){
        if(l == r){
            SegmentTreeNode node = new SegmentTreeNode(l,r, A[l]);
            return node;
        }
        
        int mid = l+(r-l)/2;
        SegmentTreeNode left = buildTree(A,l,mid);
        SegmentTreeNode right = buildTree(A, mid+1, r);
        int max = Math.max(left.max, right.max);
        SegmentTreeNode node = new SegmentTreeNode(l,r,max);
        node.left = left;
        node.right = right;
        return node;
    }
};