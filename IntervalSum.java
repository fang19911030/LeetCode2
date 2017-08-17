/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */


public class Solution {
    /*
     * @param A: An integer array.
     * @param queries: A query list.
     * @return: The result list.
     */
    class TreeNode{
        TreeNode left;
        TreeNode right;
        int start;
        int end;
        long sum;
        public TreeNode(int i, int j){
            start = i;
            end = j;
            sum = 0;
            left = null;
            right = null;
        }
    }
    
    public List<Long> intervalSum(List<Integer> A, ArrayList<Interval> queries) {
        // write your code here
        List<Long> res = new ArrayList<>();
        if(A== null || queries == null ||A.size() == 0 || queries.size() == 0){
            return res;
        }
        
        TreeNode root = buildTree(A,0,A.size()-1);
        for(Interval cur:queries){
            int start = cur.start;
            int end = cur.end;
            res.add(search(root,start,end));
        }
        return res;
        
    }
    
    private TreeNode buildTree(List<Integer> A, int l, int r){
        if(l==r){
            TreeNode node = new TreeNode(l,r);
            node.sum = A.get(l);
            return node;
        }
        if(l>r){
            return null;
        }
        
        int mid = l +(r-l)/2;
        TreeNode node= new TreeNode(l,r);
        node.left = buildTree(A,l,mid);
        node.right = buildTree(A,mid+1,r);
        node.sum = node.left.sum+node.right.sum;
        return node;
    }
    
    private Long search(TreeNode node, int start, int end){
        if(node.start == start && node.end==end){
            return node.sum;
        }

        
        int mid = node.start + (node.end-node.start)/2;
        if(end<=mid){
            return search(node.left,start,end);
        }
        if(start>mid){
            return search(node.right,start, end);
        }
        return search(node.left,start,mid)+search(node.right,mid+1,end);
    }
    
};