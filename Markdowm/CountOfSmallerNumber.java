public class Solution {
    /*
     * @param A: An integer array
     * @param queries: The query list
     * @return: The number of element in the array that are smaller that the given integer
     */
     
     class TreeNode{
         int val;
         int leftSize;
         int equals;
         int rightSize;
         TreeNode left;
         TreeNode right;
         public TreeNode(int i){
             val = i;
             leftSize = 0;
             equals = 0;
             left = null;
             right = null;
             rightSize = 0;
         }
     }
     public List<Integer> countOfSmallerNumber(int[] A, int[] queries) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        if(A == null || queries == null){
            return res;
        }
        if(A == null && queries!= null){
            for(int i=0;i<queries.length;i++){
                res.add(0);
            }
            return res;
        }
        Map<Integer, Integer> count = new HashMap<>();
        for(Integer i:A){
            if(count.containsKey(i)){
                count.put(i,count.get(i)+1);
            }else{
                count.put(i,1);
            }
        }
        List<Integer> keys = new ArrayList<>(count.keySet());
        Collections.sort(keys);
        TreeNode root = buildTree(keys,0,keys.size()-1,count);
        for(int i=0;i<queries.length;i++){
            int cur = queries[i];
            int smaller = getSmaller(root, cur);
            res.add(smaller);
        }
        return res;
    }
    
    private TreeNode buildTree(List<Integer> keys, int l, int r, Map<Integer,Integer> count){
        if(l==r){
            TreeNode node = new TreeNode(keys.get(l));
            node.equals = count.get(keys.get(l));
        }
        if(l>r){
            return null;
        }
        
        int mid = l +(r-l)/2;
        TreeNode node = new TreeNode(keys.get(mid));
        node.equals = count.get(keys.get(mid));
        node.left = buildTree(keys,l,mid-1,count);
        node.right = buildTree(keys,mid+1,r,count);
        node.leftSize = node.left==null? 0: node.left.leftSize+node.left.rightSize+node.left.equals;
        node.rightSize = node.right == null? 0:node.right.leftSize+node.right.rightSize+node.right.equals;
        return node;
    }
    
    private int getSmaller(TreeNode node, int key){
        if(node == null){
            return 0;
        }
        int res = 0;
        if(node.val == key){
            res = node.leftSize;
            return res;
        }
        if(node.val > key){
            res += getSmaller(node.left,key);
        }
        if(node.val<key){
            res += node.equals + node.leftSize;
            res += getSmaller(node.right,key);
        }
        return res;
    }
};