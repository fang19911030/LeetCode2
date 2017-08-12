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
 * Example of iterate a tree:
 * BSTIterator iterator = new BSTIterator(root);
 * while (iterator.hasNext()) {
 *    TreeNode node = iterator.next();
 *    do something for node
 * } 
 */
public class BSTIterator {
    //@param root: The root of binary tree.
    private List<TreeNode> list;
    private Iterator<TreeNode> iter;
    public BSTIterator(TreeNode root) {
        // write your code here
        list = new ArrayList<>();
        getValues(root,list);
        iter = list.iterator();
        
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        // write your code here
        return iter.hasNext();
    }
    
    //@return: return next node
    public TreeNode next() {
        // write your code here
        return iter.next();
    }
    
    private void getValues(TreeNode node, List<TreeNode> list){
        if(node == null){
            return;
        }
        getValues(node.left,list);
        list.add(node);
        getValues(node.right,list);
    }
}