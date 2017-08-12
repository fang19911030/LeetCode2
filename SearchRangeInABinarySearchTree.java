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
     * @param root: The root of the binary search tree.
     * @param k1 and k2: range k1 to k2.
     * @return: Return all keys that k1<=key<=k2 in ascending order.
     */
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        getSolution(root,k1,k2,res);
        return res;
    }

    private void getSolution(TreeNode node, int k1, int k2, ArrayList<Integer>list){
        if(node == null){
            return;
        }
        if(node.val<k1){
            getSolution(node.right, k1, k2,list);
        }else if(node.val>k2){
            getSolution(node.left,k1,k2,list);
        }else{
            getSolution(node.left,k1,k2,list);
            list.add(node.val);
            getSolution(node.right,k1,k2,list);
        }
    }
}