class Solution {
    public boolean isMatch(String s, String p) {
        if(s == null || p == null){
            return false;
        }
        char[] str = s.toCharArray();
        char[] pattern = p.toCharArray();
        int[][]dp = new int[s.length()][p.length()];
        return dfs(str, pattern, 0, 0);
    }
    
    private boolean dfs(char[] str, char[] pattern, int index1, int index2){
        if(index2 == pattern.length ){
            return index1 == str.length;
        }
        boolean res = false;
        if(pattern[index2]!='*'){
            return index1!= str.length && (pattern[index2] == '?' || pattern[index2] == str[index1]) &&
                dfs(str, pattern,index1+1,index2+1);
        }
        while(index1<=str.length){
            if(dfs(str, pattern,index1,index2+1)){
                return true;
            }
            index1++;
        }
        return false;
        //return dfs(str, pattern,index1,index2+1);
    }
}