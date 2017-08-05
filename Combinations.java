public class Solution {
    /**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */
    public List<List<Integer>> combine(int n, int k) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if(n<k){
            return res;
        }
        List<Integer> curList = new ArrayList<>();
        dfs(n,k,res,curList, 1);
        return res;
    }
    
    private void dfs(int n, int k, List<List<Integer>> res, List<Integer> curList,int cur){
        if(curList.size() == k){
            List<Integer> oneRes = new ArrayList<>(curList);
            res.add(oneRes);
            return;
        }

        for(int i=cur;i<=n;i++){
            curList.add(i);
            dfs(n,k,res,curList,i+1);
            curList.remove(curList.size()-1);
        }
    }
}