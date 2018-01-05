/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }
    
    private void serialize(TreeNode node, StringBuilder sb){
        if(node == null) return;
        
        sb.append(node.val);
        sb.append(",");
        serialize(node.left, sb);
        serialize(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")) return null;
        String[] vals = data.split(",");
        if(vals.length == 0){
            return null;
        }
        
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        for(int i=1;i<vals.length; i++){
            int val = Integer.parseInt(vals[i]);
            TreeNode pre = null;
            TreeNode cur = root;
            while(cur != null){
                pre = cur;
                if(val > cur.val){
                    cur = cur.right;
                }else{
                    cur = cur.left;
                }
            }
            if(val > pre.val){
                pre.right = new TreeNode(val);
            }else{
                pre.left = new TreeNode(val);
            }
        }
        return root;
    }
}