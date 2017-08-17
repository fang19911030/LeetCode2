class SegmendTreeNode{
    int start;
    int end;
    int minimum;
    SegmendTreeNode left;
    SegmendTreeNode right;
    
    public SegmendTreeNode(int i, int j){
        start = i;
        end = j;
        left = null;
        right = null;
        minimum = Integer.MAX_VALUE;
    }
    
}
 
public class Solution {
    /**
     *@param A, queries: Given an integer array and an query list
     *@return: The result list
     */
     
     
    public ArrayList<Integer> intervalMinNumber(int[] A, 
                                                ArrayList<Interval> queries) {
        // write your code here
        
        ArrayList<Integer> res = new ArrayList<>();
        if(A == null || queries== null || queries.size() == 0){
            return res;
        }
        
        SegmendTreeNode root = buildTree(A, 0, A.length-1);
        for(Interval cur: queries){
            int l = cur.start;
            int r = cur.end;
            res.add(search(root,l,r));
        }
        return res;
    }
    
    private SegmendTreeNode buildTree(int[]A, int l , int r){
        if(l == r){
            SegmendTreeNode node = new SegmendTreeNode(l,r);
            node.minimum = A[l];
            return node;
        }
        
        if(l>r){
            return null;
        }
        
        int mid = l+(r-l)/2;
        SegmendTreeNode  node = new SegmendTreeNode(l,r);
        node.left = buildTree(A,l,mid);
        node.right = buildTree(A, mid+1, r);
        node.minimum = Math.min(node.left.minimum, node.right.minimum);
        return node;
    }
    
    private int search(SegmendTreeNode node, int l, int r){
        if(node.start == l && node.end == r){
            return node.minimum;
        }
        
        int mid = node.start+(node.end-node.start)/2;
        if(r<=mid){
            return search(node.left,l,r);
        }else if(l>mid){
            return search(node.right,l,r);
        }else{
            return Math.min(search(node.left,l,mid),search(node.right,mid+1,r));
        }
    }
}