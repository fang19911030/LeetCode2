public class Solution {
    /**
     * @param nums: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     */
    public int houseRobber2(int[] nums) {
        // write your code her
        // int res1=0;
        // int res2=0;
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        
        if(nums.length == 2){
            return Math.max(nums[0],nums[1]);
        }
        int res1 = rob(nums,0, nums.length-2);
        int res2 = rob(nums,1, nums.length-1);
        return Math.max(res1, res2);
        

    }
    
    public int rob(int[] nums, int start, int end){
        if(end == start){
            return nums[start];
        }
        if(end -start == 1){
            return Math.max(nums[start], nums[end]);
        }
        int[] dp = new int[end-start+1];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start],nums[start+1]);
        for(int i=2;i<dp.length;i++){
            if(dp[i-2]+nums[start+i]>dp[i-1]){
                dp[i] = dp[i-2]+nums[start+i];
            }else{
                dp[i] = dp[i-1];
            }
        }
        return dp[dp.length-1];
    }
}