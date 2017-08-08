public class Solution {
    /**
     * @param A an array
     * @return total of reverse pairs
     */
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        int count;
        int equals;

        TreeNode(int val){
            this.val = val;
            equals = 1;
            count = 0;
            left = null ;
            right = null;
        }
    }
    long res = 0;
    TreeNode root=null;


    public long reversePairs(int[] A) {
        // Write your code here
        for(int i=0;i<A.length;i++){
            BuildTree(A,i);
            search(root,A,i);
        }
        return res;
    }
    private void BuildTree(int[] A, int i){
        root = BuildTree(root,A,i);
    }

    private TreeNode BuildTree(TreeNode node, int[] A, int i){
        TreeNode cur = node;
        if(cur != null){
            if(A[i] == cur.val){
                cur.equals++;
            }else if(A[i]>cur.val){
                cur.count++;
                cur.right = BuildTree(cur.right,A,i);
            }else{
                cur.left = BuildTree(cur.left,A,i);
            }
        }else{
            cur = new TreeNode(A[i]);
        }
        return cur;

    }

    private void search(TreeNode node, int[] A, int i){
        if(A[i] == node.val){
            res +=node.count;
            return;
        }else if(A[i]<node.val){
            res += node.equals + node.count;
            search(node.left,A,i);
        }else{
            search(node.right,A,i);
        }
    }
}