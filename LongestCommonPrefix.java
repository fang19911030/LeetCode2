class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            String res ="";
            return res;
        }
        
        Arrays.sort(strs,(String a, String b)-> a.length()-b.length());
        for(int i=strs[0].length();i>=1;i--){
            int t = 1;
            String prefix = strs[0].substring(0,i);
            for(int j=1;j<strs.length;j++){
                if(strs[j].startsWith(prefix)){
                    t++;
                }
            }
            if(t == strs.length){
                return prefix;
            }
        }
        String res = "";
        return res;
    }
}