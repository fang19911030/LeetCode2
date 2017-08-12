public class Solution {
    /**
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here
        if(root == null ){
            root = node;
            return root;
        }
        insert(root, node);
        return root;
    }
    
    private void insert(TreeNode cur, TreeNode node){
        if(cur.val<node.val){
            if(cur.right == null){
                cur.right = node;
                return;
            }else{
                insert(cur.right,node);
            }
        }else{
            if(cur.left == null){
                cur.left = node;
                return;
            }else{
                insert(cur.left,node);
            }
        }
    }
}