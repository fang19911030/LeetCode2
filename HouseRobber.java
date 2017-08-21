public class Solution {
    /*
     * @param A: An array of non-negative integers
     * @return: The maximum amount of money you can rob tonight
     */
    public long houseRobber(int[] A) {
        // write your code here
        if(A == null || A.length == 0){
            return 0;
        }
        if(A.length==1){
            return A[0];
        }
        if(A.length == 2){
            long res = Math.max(A[0], A[1]);
            return res;
        }
        long[] dp = new long[A.length];
        dp[0] = A[0];
        dp[1] = Math.max(A[0],A[1]);
        for(int i=2;i<A.length;i++){
            if(dp[i-2]+A[i]>dp[i-1]){
                dp[i] = dp[i-2]+A[i];
            }else{
                dp[i] = dp[i-1];
            }
        }
        return dp[dp.length-1];
        
        
    }
}