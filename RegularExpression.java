class Solution {
    public boolean isMatch(String s, String p) {
        if(s == null || p == null){
            return false;
        }
        char[] str = s.toCharArray();
        char[] pattern = p.toCharArray();
        if(!isValid(str,pattern)){
            return false;
        }
        return dfs(str,pattern,0,0);
    }
    
    private boolean dfs(char[] str, char[] pattern, int index1, int index2){
        if(index2 == pattern.length){
            return index1==str.length;
        }
        
        if(index2+1 == pattern.length || pattern[index2+1] != '*'){
            return index1!=str.length && (pattern[index2]=='.' || pattern[index2] == str[index1]) &&
                dfs(str, pattern, index1+1, index2+1);
        }
        while(index1!=str.length && (pattern[index2]=='.' || pattern[index2] == str[index1])){
            if(dfs(str, pattern,index1,index2+2)){
                return true;
            }
            index1++;
        }
        return dfs(str,pattern,index1,index2+2);
    }
    
    private boolean isValid(char[] str, char[] p){
        for(int i=0; i < str.length ;i++){
            if(str[i] == '.' || str[i] =='*'){
                return false;
            }
        }
        
        for(int i=0;i<p.length;i++){
            if(p[i] == '*' && ( i==0 || p[i-1]=='*')){
                return false;
            }
        }
        
        return true;
    }
    
}