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
 * 
 */
 
 
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: Level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // write your code here
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            Queue<TreeNode>next = new LinkedList<>();
            ArrayList<Integer> subres = new ArrayList<>();
            while(!queue.isEmpty()){
                TreeNode cur = queue.poll();
                subres.add(cur.val);
                if(cur.left != null){
                    next.offer(cur.left);
                }
                if(cur.right != null){
                    next.offer(cur.right);
                }
            }
            queue = next;
            res.add(subres);
        }
        return res;
    }
}