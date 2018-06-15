class Solution {
    public int findLUSlength(String[] strs) {
        Arrays.sort(strs, (a, b)->b.length() - a.length());
        Set<String>  duplicated = getDup(strs);
        
        for(int i=0; i< strs.length; i++){
            if(!duplicated.contains(strs[i])){
                if(i == 0) return strs[i].length();
                for(int j=0;j<i; j++){
                    if(isSub(strs[j], strs[i])) break;
                    if(j == i-1) return strs[i].length();
                }
            }
        }
        return -1;
    }
    
    private Set<String> getDup(String[] strs){
        Set<String> str = new HashSet<>();
        Set<String> dup = new HashSet<>();
        for(String s : strs){
            if(!str.add(s)){
                dup.add(s);
            }
        }
        return dup;
    }
    
    private boolean isSub(String a, String b){
        int i=0, j=0;
        while(i< a.length() && j<b.length()){
            if(a.charAt(i) == b.charAt(j)) j++;
            i++;
        }
        return j==b.length();
    }
}