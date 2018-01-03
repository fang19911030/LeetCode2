class Solution {
    public int countUnivalSubtrees(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        int[] res= new int[1];
        help(root, res);
        return res[0];
    }
    
    private Set<Integer> help(TreeNode node, int[] res){
        if(node == null){
            return new HashSet<Integer>();
        }
        
        Set<Integer> leftSub = help(node.left, res);
        Set<Integer> rightSub = help(node.right, res);
        Set<Integer> cur = merge(leftSub, rightSub, node);
        if(cur.size() == 1){
            res[0]++;
        }
        return cur;
    }
    
    private Set<Integer> merge(Set<Integer> leftSub, Set<Integer> rightSub, TreeNode node){
        Set<Integer> res = new HashSet<Integer>();
        res.add(node.val);
        for(Integer i:leftSub){
            res.add(i);
        }
        for(Integer i:rightSub){
            res.add(i);
        }
        return res;
    }
}