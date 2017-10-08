class Solution {
    public boolean isMatch(String s, String p) {
        if( p == null || p.length() == 0){
            return s== null  || s.length() == 0;
        }
        
        // if( s == null || s.length() == 0){
        //     return p == null || p.length() == 0;
        // }
        
        char[] str = s.toCharArray();
        char[] pat = p.toCharArray();
        int[][] dp= new int[str.length+1][pat.length+1];
        return dfs(str, pat, 0,0,dp);
    }
    
    private boolean dfs(char[] str, char[] pat, int idx1, int idx2, int[][] dp){
        if(idx2 == pat.length){
            return idx1 == str.length;
        }
        
        if(dp[idx1][idx2] != 0){
            return dp[idx1][idx2] == 1;
        }
        
        boolean res = false;
        if(pat[idx2] !='*'){
            res = (idx1 < str.length) && (pat[idx2] == '?' || pat[idx2] == str[idx1]) && dfs(str,pat,idx1+1,idx2+1,dp);
            dp[idx1][idx2] = res == true? 1:-1;
            return res;
        }else{
            int idx  = idx1;
            while(idx < str.length){
                if(dfs(str,pat,idx+1,idx2+1, dp)){
                    dp[idx1][idx2] = 1;
                    return true;
                }
                idx++;
            }
            res = dfs(str, pat, idx1, idx2+1,dp);
            dp[idx1][idx2] = res==true? 1:-1;
            return res;
        }
    }
}