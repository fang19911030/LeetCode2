public class Solution {
    /**
     * @param word1 & word2: Two string.
     * @return: The minimum number of steps.
     */
    public int minDistance(String word1, String word2) {
        // write your code here
        if(word1== null && word2 == null){
            return 0;
        }
        
        if(word1!= null && word2 == null){
            return word1.length();
        }
        
        if(word1 == null && word2 != null){
            return word2.length();
        }
        
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        char[] str1 = word1.toCharArray();
        char[] str2 = word2.toCharArray();
        
        for(int i=0;i<dp.length;i++){
            dp[i][0] = i;
        }
        for(int j=0;j<dp[0].length;j++){
            dp[0][j] = j;
        }
        
        for(int i=0;i<str1.length;i++){
            for(int j=0;j<str2.length;j++){
                if(str1[i]==str2[j]){
                    dp[i+1][j+1] = dp[i][j];
                }else{
                    dp[i+1][j+1] =Math.min(dp[i][j],Math.min(dp[i+1][j],dp[i][j+1]))+1;
                }
            }
        }
        return dp[str1.length][str2.length];
    }
}