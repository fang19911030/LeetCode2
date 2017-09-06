public class Solution {
    /*
     * @param A: an integer array
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    class TreeNode{
        int val;
        int equal;
        int small;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
            equal = 1;
            small = 0;
            left = null;
            right = null;
        }
    }
    TreeNode root;
    public List<Integer> countOfSmallerNumberII(int[] A) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        if(A == null || A.length == 0){
            return res;
        }
        root = new TreeNode(A[0]);
        res.add(0);
        for(int i=1;i<A.length;i++){
            insert(root, A[i]);
            res.add(search(root,A[i]));
        }
        return res;
    }
    
    private void insert(TreeNode node, int val){
        if(node == null){
            return;
        }
        if(node.val == val){
            node.equal++;
            return;
        }
        
        if(node.val> val){
            node.small++;
            if(node.left != null){
                insert(node.left, val);
            }else{
                node.left = new TreeNode(val);
            }
        }else{
            if(node.right != null){
                insert(node.right, val);
            }else{
                node.right = new TreeNode(val);
            }
        }

    }
    
    private int search(TreeNode node, int val){
        if(node.val == val){
            return node.small;
        }
        
        if(node.val > val){
            return search(node.left,val);
        }else{
            return node.equal + node.small + search(node.right, val);
        }
    }
}