public class NumMatrix {
    
    class TreeNode{
        int start;
        int end;
        TreeNode left;
        TreeNode right;
        int sum;
        TreeNode(int i, int j){
            start = i;
            end = j;
            sum = 0;
            left = null;
            right = null;
        }
    }
    TreeNode[] roots;
    public NumMatrix(int[][] matrix) {
        roots = new TreeNode[matrix.length];
        for(int i=0;i<roots.length;i++){
            roots[i]=buildTree(matrix[i],0,matrix[i].length-1);
        }

    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for(int i=row1;i<=row2;i++){
            sum += getSum(roots[i],col1,col2);
        }
        return sum;
    }
    
    
    private TreeNode buildTree(int[]arr, int start, int end){
        if(start == end){
            TreeNode node = new TreeNode(start, end);
            node.sum = arr[start];
            return node;
        }
        
        int mid = start +((end-start)>>1);
        TreeNode node = new TreeNode(start,end);
        node.left = buildTree(arr,start,mid);
        node.right = buildTree(arr,mid+1,end);
        node.sum = node.left.sum+node.right.sum;
        return node;
    }
    
    
    private int getSum(TreeNode node, int start, int end){
        if(start == node.start && end == node.end){
            return node.sum;
        }
        int l = node.start;
        int r = node.end;
        int mid = l+((r-l)>>1);
        if(end<=mid){
            return getSum(node.left,start,end);
        }else if(start>mid){
            return getSum(node.right,start,end);
        }else{
            return getSum(node.left,start,mid)+getSum(node.right,mid+1,end);
        }
    }
}