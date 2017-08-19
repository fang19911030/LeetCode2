public class Solution {
    /**
     * @param n non-negative integer, n posts
     * @param k non-negative integer, k colors
     * @return an integer, the total number of ways
     */
    public int numWays(int n, int k) {
        // Write your code here
        if(n > 2 && k == 1){
            return 0;
        }

        if(n == 1){
            return k;
        }

        int factor = k - 1;
        int[] dp = new int[3];
        dp[0] = k;
        dp[1] = k * k;

        for(int i = 2; i < n; i++){
            dp[i % 3] = factor * (dp[(i - 1) % 3] + dp[(i - 2) % 3]);
        }

        return dp[(n - 1) % 3];
    }
}