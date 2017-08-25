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
     * @paramn n: An integer
     * @return: A list of root
     */
    List<TreeNode>[][] lists;
    public List<TreeNode> generateTrees(int n) {
        // write your code here
        List<TreeNode> res = new ArrayList<>();
        if( n == 0 ){
            TreeNode root = null;
            res.add(root);
            return res;
        }
        lists = (List<TreeNode>[][]) new List[n][n];
        return generateTrees(1,n);
    }
    
    private List<TreeNode> generateTrees(int start, int end){
        List<TreeNode> res = new ArrayList<>();
        if(start == end){
            TreeNode node = new TreeNode(start);
            res.add(node);
            return res;
        }
        if(lists[start-1][end-1]!= null){
            return lists[start-1][end-1];
        }
        for(int i=start;i<=end;i++){
            if(i == start ){
                List<TreeNode> right = generateTrees(i+1,end);
                for(TreeNode n:right){
                    TreeNode root = new TreeNode(start);
                    root.right = n;
                    res.add(root);
                }
            }else if(i == end){
                List<TreeNode> left = generateTrees(start,end-1);
                for(TreeNode n:left){
                    TreeNode root = new TreeNode(end);
                    root.left = n;
                    res.add(root);
                }
            }else{
                List<TreeNode> left = generateTrees(start,i-1);
                List<TreeNode> right = generateTrees(i+1,end);
                for(TreeNode l:left){
                    for(TreeNode r:right){
                        TreeNode root = new TreeNode(i);
                        root.left = l;
                        root.right = r;
                        res.add(root);
                    }
                }
            }
        }
        lists[start-1][end-1] = res;
        return res;
    }
}