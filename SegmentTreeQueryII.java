public class Solution {
    /*
     * @param root: The root of segment tree.
     * @param start: start value.
     * @param end: end value.
     * @return: The count number in the interval [start, end]
     */
    

     public int query(SegmentTreeNode root, int start, int end) {        
         if (root == null || root.end < start || root.start > end) return 0;             //The Boundary Condition
         if (root.start>=start && root.end<=end) return root.count;
         int mid = (root.start + root.end)/2;
         if (end <= mid) return query(root.left, start, end);
         else if (start > mid) return query(root.right, start, end);
         else return query(root.left, start, mid) + query(root.right, mid+1, end);
     }
    
};