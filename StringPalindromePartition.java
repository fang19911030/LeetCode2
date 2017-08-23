public class Solution {
    /**
     * @param s a string
     * @return an integer
     */
    public int minCut(String s) {
        // write your code here
        if(s== null || s.length() <=1){
            return 0;
        }
        char[] str = s.toCharArray();
        int[][] dp = new int[str.length][str.length];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        return help(str,0,str.length, dp);
        
        
    }
    
    
    private int help(char[] str, int start, int length, int[][] dp){
        if(start>= str.length){
            return 0;
        }
        if(dp[start][length-1]!= Integer.MAX_VALUE){
            return dp[start][length-1];
        }
        int min = Integer.MAX_VALUE;
        for(int i=length;i>=1;i--){
            int res = 0;
            if( i == length && isPalindrome(str,start,start+i-1)){
                res += help(str,start+i,str.length-start-i,dp);
                min = Math.min(res, min);
            }else if(i != length && isPalindrome(str,start,start+i-1)){
                res =1+ help(str,start+i,str.length-start-i,dp);
                min = Math.min(res, min);
            }
        }
        dp[start][length-1] = min;
        return min;
    }
    
    private boolean isPalindrome(char[] str, int i, int j){
        if(i>j){
            return false;
        }
        while(i<=j){
            if(str[i++]!= str[j--]){
                return false;
            }
        }
        return true;
    }
};