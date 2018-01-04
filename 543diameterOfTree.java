class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        int[]res = new int[1];
        help(root, res);
        return res[0]-1;
    }
    
    private int help(TreeNode node, int[] res){
        if(node == null){
            return 0;
        }
        
        int left = help(node.left, res);
        int right = help(node.right, res);
        res[0] = Math.max(res[0], left + right +1);
        return Math.max(left, right)+1;
    }
}