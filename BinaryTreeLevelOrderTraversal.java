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
     * @param root: The root of binary tree.
     * @return: buttom-up level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        // write your code here
        Deque<ArrayList<Integer>> stack = new ArrayDeque<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Queue<TreeNode> next = new LinkedList<>();
            ArrayList<Integer> val = new ArrayList<>();
            while(!queue.isEmpty()){
                TreeNode cur = queue.poll();
                val.add(cur.val);
                if(cur.left != null){
                    next.offer(cur.left);
                }
                if(cur.right != null){
                    next.offer(cur.right);
                }
            }
            if(val.size()!=0){
                stack.push(val);
            }
            queue = next;
        }
        
        while(!stack.isEmpty()){
            res.add(stack.pop());
        }
        return res;
    }
}