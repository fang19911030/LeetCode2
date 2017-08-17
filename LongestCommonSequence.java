public class Solution {
    /**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */
    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        if(A == null || B == null || A.length() == 0 || B.length() == 0){
            return 0;
        }
        int[][] dp = new int[A.length()][B.length()];
        char[] strA =  A.toCharArray();
        char[] strB = B.toCharArray();
        for(int i=0;i<strA.length;i++){
            if(strA[i]==strB[0]){
                dp[i][0] = 1;
            }
        }
        
        for(int j=0;j<strB.length;j++){
            if(strB[j] == strA[0]){
                dp[0][j] = 1;
            }
        }
        
        for(int i=1;i<strA.length;i++){
            for(int j=1;j<strB.length;j++){
                if(strA[i]== strB[j]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        
        return dp[strA.length-1][strB.length-1];
    }
}