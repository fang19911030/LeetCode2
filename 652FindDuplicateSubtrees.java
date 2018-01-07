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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        postorder(root, map, res);
        return res;
    }
    
    private String postorder(TreeNode node, Map<String, Integer> map, List<TreeNode>res){
        if(node == null) return "#";
        String serial = node.val +"," + postorder(node.left, map, res) + postorder(node.right, map, res);
        if(!map.containsKey(serial)){
            map.put(serial,0);
        }
        map.put(serial,map.get(serial)+1);
        if(map.get(serial)==2){
            res.add(node);
        }
        return serial;
    }
}