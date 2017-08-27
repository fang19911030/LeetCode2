public class Solution {
    /**
     * @param nums: A list of integers
     * @param k: An integer denote to find k non-overlapping subarrays
     * @return: An integer denote the sum of max k non-overlapping subarrays
     */
    public int maxSubArray(int[] nums, int k) {
        // write your code here
        if(k>= nums.length){
            int sum = 0;
            for(int i=0;i<nums.length;i++){
                sum += nums[i];
            }
            return sum;
        }
        int[][]dp = new int[nums.length][k];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        
        return dfs(nums,0,nums.length-1,0,k,dp);
    }
    
    private int dfs(int[] nums,int start, int end, int index, int k,int[][]dp){
        if(index >=k){
            return 0;
        }
        if(dp[start][index]!= Integer.MIN_VALUE){
            return dp[start][index];
        }
        
        int cur = Integer.MIN_VALUE;
        int res = Integer.MIN_VALUE;
        for(int i=start;i<=end-(k-index-1);i++){
            cur = maxSubArray(nums,start,i) + dfs(nums,i+1,end,index+1,k,dp);
            res = Math.max(res,cur);
        }
        dp[start][index] = res;
        return res;
    }
    

    
    private int maxSubArray(int[] nums, int start, int end){
        int l = end-start+1;
        int res = Integer.MIN_VALUE;
        int sum = 0;
        int minsum = 0;
        for(int i=start;i<=end;i++){
            sum += nums[i];
            res = Math.max(res, sum-minsum);
            minsum = Math.min(sum,minsum);
        }
        return res;
    }
}
