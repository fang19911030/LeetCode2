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
     * @param root: The root of segment tree.
     * @param index: index.
     * @param value: value
     * @return: 
     */
    
    public void modify(SegmentTreeNode root, int index, int value) {
        // write your code here
        if(root.start == index && root.end == index){
            root.max = value;
            return;
        }
        int left = root.start;
        int right = root.end;
        int mid = (left+right)/2;
        if(index<=mid){
            modify(root.left,index,value);
        }else{
            modify(root.right,index,value);
        }
        root.max = Math.max(root.left.max, root.right.max);
    }
    
};