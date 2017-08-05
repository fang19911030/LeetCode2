public class Solution {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    Set<List<Integer>> set;
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if(num == null || num.length == 0){
            return res;
        }
        Arrays.sort(num);
        set = new HashSet<>();
        List<Integer> curList = new ArrayList<>();
        dfs(num,target,0,0,res,curList);
        return res;
    }
    
    private void dfs(int[] arr,int target, int index, int curSum, List<List<Integer>> res,List<Integer>curList){
        if(curSum>target){
            return;
        }
        if(index>= arr.length){
            if(curSum == target){
                List<Integer> sub = new ArrayList<>(curList);
                if(set.add(sub)){
                    res.add(sub);
                }
                return;
            }
        }
        if(index< arr.length && curSum==target){
            List<Integer> sub = new ArrayList<>(curList);
            if(set.add(sub)){
                res.add(sub);
            }
            return;
        }
        
        for(int i=index;i<arr.length;i++){
            curList.add(arr[i]);
            dfs(arr,target,i+1,curSum+arr[i],res,curList);
            curList.remove(curList.size()-1);
        }
    }
    
    
}