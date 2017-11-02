class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s == null || s.length() == 0){
            return true;
        }
        if((t != null && s.length() > t.length() )|| t == null ){
            return false;
        }
        
        boolean[][] dp = new boolean[s.length() + 1][t.length() + 1];
        for(int j=0; j< dp[0].length; j++){
            dp[0][j] = true;
        }
        
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[i].length; j++){
                if(s.charAt(i-1)== t.charAt(j-1) && dp[i-1][j-1]){
                    dp[i][j] = true;
                }else{
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[s.length()][t.length()];
    }
}
