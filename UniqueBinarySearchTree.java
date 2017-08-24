public class Solution {
    /**
     * @paramn n: An integer
     * @return: An integer
     */
    int[] dp;
    public int numTrees(int n){
        dp = new int[n+1];
        dp[0] = 1;
        return help(n);
        
    }
    private int help(int n) {
        // write your code here
        if(n==0){
            return 1;
        }
        if(dp[n]!=0){
            return dp[n];
        }
        int sum = 0;
        for(int i=1;i<=n;i++){
            if(i == 1 || i==n){
                sum += help(n-1);
            }else{
                sum += help(i-1)*help(n-i);
            }
        }
        dp[n] = sum;
        return sum;
    }
}