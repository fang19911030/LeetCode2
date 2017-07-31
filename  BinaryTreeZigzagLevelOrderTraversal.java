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
     * @return: A list of lists of integer include 
     *          the zigzag level order traversal of its nodes' values 
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        boolean leftToRight = true;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Deque<TreeNode> next = new LinkedList<>();
            ArrayList<Integer> subres = new ArrayList<>();
            while(!queue.isEmpty()){
                if(leftToRight){
                    TreeNode cur = queue.poll();
                    subres.add(cur.val);
                    if(cur.left != null){
                        next.offer(cur.left);
                    }
                    if(cur.right != null){
                        next.offer(cur.right);
                    }
                }else{
                    TreeNode cur = queue.poll();
                    subres.add(0, cur.val);
                    if(cur.left != null){
                        next.offer(cur.left);
                    }
                    if(cur.right != null){
                        next.offer(cur.right);
                    }
                }
            }
            queue = next;
            res.add(subres);
            leftToRight = leftToRight==true? false:true;
        }
        return res;
        
    }
}