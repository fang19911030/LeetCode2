public class Solution {
    /**
     * @param nums an integer array and all positive numbers, no duplicates
     * @param target an integer
     * @return an integer
     */
    public int backPackVI(int[] nums, int target) {
        // Write your code here
        
        if(nums == null || target == 0){
            return 0;
        }
        Arrays.sort(nums);
        return help(nums, target,0);
    }
    
    private int help(int[] nums, int target, int cur){
        if(cur > target){
            return 0;
        }
        
        if(cur == target){
            return 1;
        }
        
        int res = 0;
        for(int i=0;i<nums.length;i++){
            res += help(nums, target,cur+nums[i]);
        }
        return res;
    }

    public int backPackVI2(int[] nums, int target) {
        // Write your code here
        int[] dp = new int[target+1];
        dp[0] = 1;
        
        for(int i=1;i<=target;i++){
            for(int j=0;j<nums.length;j++){
                if(i>=nums[j]){
                    dp[i] += dp[i-nums[j]];
                }
            }
        }
        return dp[target];
    }
}