/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightView(root, result, 0);
        return result;
    }
    public void rightView(TreeNode cur, List<Integer>result, int currDepth){
        if (cur==null){
            return;
        }
        if(currDepth==result.size()){
            result.add(cur.val);
        }
        rightView(cur.right, result,currDepth+1);
        rightView(cur.left,result,currDepth+1);
    }
}


public class Solution2{
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if( root == null){
            return res;
        }
        
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int rightMost = queue.size();
            int size = rightMost;
            for(;size>0;size--){
                TreeNode cur = queue.poll();
                if(size == rightMost){
                    res.add(cur.val);
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                }
                if(cur.left != null){
                    queue.offer(cur.left);
                }
            }
        }
        return res;
    }   
}