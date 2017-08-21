public class Solution {
    /**
     * @param nums a set of distinct positive integers
     * @return the largest subset 
     */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        // Write your code here
        if(nums == null ){
            return null;
        }
        List<Integer>[] res = (List<Integer>[]) new List[nums.length];
        
        Arrays.sort(nums);
        
        res[0] = new ArrayList<>();
        res[0].add(nums[0]);
        
        for(int i=1;i<nums.length;i++){
            for(int j=i-1;j>=0;j--){
                if(nums[i] % nums[j] == 0){
                    res[i] = new ArrayList<>(res[j]);
                    res[i].add(nums[i]);
                    break;
                }
            }
            if(res[i] == null){
                res[i] = new ArrayList<>();
                res[i].add(nums[i]);
            }
        }
        List<Integer> r = null;
        for(int i=1;i<res.length;i++){
            if(r == null){
                r = res[i];
            }else{
                if(res[i].size()>r.size()){
                    r = res[i];
                }
            }
        }
        return r;
    }
}