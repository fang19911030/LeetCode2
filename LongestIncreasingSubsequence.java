class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxRes = 1;
        for(int i=1;i<nums.length;i++){
            int max = 1;
            for(int j=0;j<=i;j++){
                if(nums[i]>nums[j]){
                    max = Math.max(max,dp[j]+1);
                }
            }
            dp[i] = max;
            maxRes = Math.max(maxRes, dp[i]);
        }
        return maxRes;
        
    }
}