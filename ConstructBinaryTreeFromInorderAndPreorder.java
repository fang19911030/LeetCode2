public class Solution {
    /**
     *@param preorder : A list of integers that preorder traversal of a tree
     *@param inorder : A list of integers that inorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // write your code here
        if(preorder == null || inorder == null || inorder.length != preorder.length){
            return null;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<inorder.length ;i++){
            map.put(inorder[i],i);
        }
        
        TreeNode root = buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1,map);
        return root;
    }
    
    private TreeNode buildTree(int[] pre, int l1, int r1, int[] in, int l2, int r2, Map<Integer,Integer> map){
        if(l1> r1 || l2 >r2){
            return null;
        }
        
        TreeNode root = new TreeNode(pre[l1]);
        int idx = map.get(pre[l1]);
        root.left = buildTree(pre,l1+1,l1+idx-l2,in,l2, idx-1,map);
        root.right = buildTree(pre,l1+idx-l2+1,r1,in,idx+1,r2,map);
        return root;
    }
}
