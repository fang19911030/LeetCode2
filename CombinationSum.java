public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
     Set<List<Integer>> set;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if(candidates == null || candidates.length == 0){
            return res;
        }
        Arrays.sort(candidates);
        set = new HashSet<>();
        List<Integer> cur = new ArrayList<>();
        help(candidates, target,0,0,res,cur);
        return res;
    }
    
    private void help(int[]arr, int target, int cur, int index, List<List<Integer>>res, List<Integer> curList){
        if(index>=arr.length){
            if(cur == target){
                List<Integer> subres = new ArrayList<>(curList);
                if(set.add(subres)){
                    res.add(subres);
                }
            }
            return;
        }
        
        if(index< arr.length && cur == target){
            List<Integer> subres = new ArrayList<>(curList);
            if(set.add(subres)){
                res.add(subres);
            }
            return;
        }
        if(cur > target){
            return;
        }
        
        for(int i=index;i<arr.length;i++){
            curList.add(arr[i]);
            help(arr,target,cur+arr[i],i,res,curList);
            curList.remove(curList.size()-1);
        }
    }
}