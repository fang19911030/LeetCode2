/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param root the root of binary tree
     * @param target an integer
     * @return all valid paths
     */
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // Write your code here

        List<List<Integer>> allPaths = new ArrayList<>();
        if(root == null){
            return allPaths;
        }
        List<Integer> path = new ArrayList<>();
        getPaths(root,allPaths, path,target,0);
        return allPaths;

    }

    private void getPaths(TreeNode root, List<List<Integer>> res, List<Integer>cur,int target, int sum){
        cur.add(root.val);
        if(sum+root.val == target && root.left == null &&root.right== null){
            List<Integer> sub = new ArrayList<>(cur);
            res.add(sub);
            return;
        }

        if(root.left != null){
            getPaths(root.left,res,cur,target,sum+root.val);
            cur.remove(cur.size()-1);
        }

        if(root.right!= null){
            getPaths(root.right,res,cur ,target,sum+root.val);
            cur.remove(cur.size()-1);
        }
    }
}