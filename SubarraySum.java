public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySum(int[] nums) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return res;
        }
        int[][] dp = new int[nums.length][nums.length];
        for(int t=1;t<=nums.length;t++){
            for(int i=0;i+t-1<nums.length;i++){
                int j = i+t-1;
                if(j==i){
                    dp[i][j] = nums[i];
                    if(nums[i]==0){
                        res.add(i);
                        res.add(i);
                        return res;
                    }
                }else{
                    for(int u=i+1;u<=j;u++){
                        dp[i][u] = dp[i][u-1]+nums[u];
                        if(dp[i][u]==0){
                            res.add(i);
                            res.add(u);
                            return res;
                        }
                    }
                }
            }
        }
        return res;
    }


    public ArrayList<Integer> subarraySum2(int[] nums) {
        ArrayList<Integer> res = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return res;
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum +=nums[i];
            if(map.containsKey(sum)){
                res.add(map.get(sum)+1);
                res.add(i);
                return res;
            }
            map.put(sum,i);
        }
        return res;
        
    }
}