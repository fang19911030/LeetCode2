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
class Solution {
    /**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        // write your code here
        String res = "";
        if(root == null){
            return "#";
        }
        StringBuilder sb = new StringBuilder();
        res = getString(root, sb);
        return res;
    }

    private String getString(TreeNode node, StringBuilder sb){
        sb.append(String.valueOf(node.val));
        if(node.left!= null){
            getString(node.left, sb.append(","));
        }else{
            sb.append(",#");
        }
        if(node.right != null){
            getString(node.right, sb.append(","));
        }else{
            sb.append(",#");
        }
        return sb.toString();
    }
    
    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        String[] tree = data.split(",");
        int[] index={0};
        TreeNode root=getTree(tree, index);
        return root;
    }
    
    private TreeNode getTree(String[] arr, int[] index){
        if(index[0]>=arr.length){
            return null;
        }
        
        if(arr[index[0]].equals("#")){
            return null;
        }
        
        TreeNode root = new TreeNode(Integer.valueOf(arr[index[0]++]));
        root.left = getTree(arr,index);
        index[0]++;
        root.right = getTree(arr,index);
        return root;
        
    }
}