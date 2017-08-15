/**
 * Definition of SegmentTreeNode:
 * public class SegmentTreeNode {
 *     public int start, end;
 *     public SegmentTreeNode left, right;
 *     public SegmentTreeNode(int start, int end) {
 *         this.start = start, this.end = end;
 *         this.left = this.right = null;
 *     }
 * }
 */


public class Solution {
    /*
     * @param start: start value.
     * @param end: end value.
     * @return: The root of Segment Tree.
     */
    
    public SegmentTreeNode build(int start, int end){
        SegmentTreeNode root = buildTree(start, end);
        return root;
    }
    
    private SegmentTreeNode buildTree(int start, int end){
        if(start == end){
            SegmentTreeNode node = new SegmentTreeNode(start, end);
            return node;
        }
        if(start>end){
            return null;
        }
        int mid = (start+end)/2;
        SegmentTreeNode node = new SegmentTreeNode(start, end);
        node.left = buildTree(start, mid);
        node.right = buildTree(mid+1, end);
        return node;
    }
    
};