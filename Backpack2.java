public class Solution {
    /*
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @param V: Given n items with value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int[] V) {
        // write your code here
        int[][] dp = new int[A.length+1][m+1];
        for(int i=1;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(j>=A[i-1]){
                    dp[i][j] = Math.max(dp[i-1][j-A[i-1]]+V[i-1],dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        return dp[A.length][m];
    }
};