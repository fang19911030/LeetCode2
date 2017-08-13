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
     * @return: Postorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        Deque<TreeNode> stack1 = new ArrayDeque<>();
        Deque<TreeNode> stack2 = new ArrayDeque<>();
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        stack1.push(root);
        while(!stack1.isEmpty()){
            TreeNode cur = stack1.pop();
            if(cur.left != null){
                stack1.push(cur.left);
            }
            if(cur.right != null){
                stack1.push(cur.right);
            }
            
            stack2.push(cur);
        }
        
        while(!stack2.isEmpty()){
            res.add(stack2.pop().val);
        }
        return res;
    }
}