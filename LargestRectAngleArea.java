public class Solution {
    /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public int largestRectangleArea(int[] height) {
        // write your code here
        int[][] dp = new int[height.length][height.length];
        for(int i=0;i<dp.length;i++){
            dp[i][i] = height[i];
        }
        for(int t=2;t<=height.length;t++){
            for(int i=0;i+t-1<height.length;i++){
                int min = Integer.MAX_VALUE;
                for(int j=i+t-1;j>=i;j--){
                    min = Math.min(min,height[j]);
                }
                dp[i][i+t-1] = min*t;
            }
        }
        int res =0;
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp.length;j++){
                res = Math.max(res,dp[i][j]);
            }
        }
        return res;
    }
}