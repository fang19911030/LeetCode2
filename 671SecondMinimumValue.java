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
    public int findSecondMinimumValue(TreeNode root) {
        if(root == null) return -1;
        TreeSet<Integer> set = new TreeSet<>();
        getVals(root, set);
        if(set.size() == 1) return -1;
        return set.higher(set.first());
    }
    
    private void getVals(TreeNode node, TreeSet<Integer> vals){
        if(node == null) return;
        vals.add(node.val);
        getVals(node.left, vals);
        getVals(node.right, vals);
    }
}