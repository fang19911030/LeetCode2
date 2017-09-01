/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int largestBSTSubtree(TreeNode root) {
        int[] rootInfo = isBSTAndSize(root);
        if(rootInfo[0] == 1){
            return rootInfo[1];
        }
        int left = largestBSTSubtree(root.left);
        int right = largestBSTSubtree(root.right);
        return Math.max(left,right);
    }
    
    private int[] isBSTAndSize(TreeNode node){
        if(node == null){
            return new int[]{1,0};
        }
        List<TreeNode> inorder  = new ArrayList<>();
        getInorder(node, inorder);
        int[] res = new int[2];
        res[1] = inorder.size();
        if(inorder.size() == 1){
            res[0] = 1;
            return res;
        }
        for(int i=1;i<inorder.size();i++){
            TreeNode pre = inorder.get(i-1);
            TreeNode cur = inorder.get(i);
            if(cur.val<=pre.val){
                res[0] = -1;
                return res;
            }
        }
        res[0] = 1;
        return res;
    }
    
    private void getInorder(TreeNode node, List<TreeNode> inorder){
        if(node == null){
            return;
        }
        getInorder(node.left, inorder);
        inorder.add(node);
        getInorder(node.right, inorder);
    }


    class Result{
        int size;
        int lower;
        int upper;

        Result(int size, int lower, int uppder){
            this.size = size;
            this.lower = lower;
            this.upper = uppder;
        }

        int max = 0;

        public int largestBSTSubtree2(TreeNode root){
            if ( root == null){ return 0;}
            traverse(root, null);
            return max;
        }

        private Result traverse(TreeNode root, TreeNode parent){
            if (root == null ){
                return new Result(0,parent.val,parent.val);
            }
            Result left = traverse(root.left, root);
            Result right = traverse(root.right, root);
            if(left.size == -1 || right.size == -1 || root.val<left.upper || root.val > right.lower){
                return new Result(-1,0,0);
            }

            int size = left.size + 1 + right.size;
            max = Math.,ax(size, max);
            return new Result(size, left.lower, right.upper);
        }
    }
}