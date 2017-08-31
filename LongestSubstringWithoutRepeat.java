class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s== null || s.length() == 0){
            return 0;
        }
        
        for(int i=s.length();i>=1;i--){
            for(int j=0;j<=s.length()-i;j++){
                String sub = s.substring(j,j+i);
                if(!isRepeated(sub)){
                    return i;
                }
            }
        }
        return 0;
    }
    
    private boolean isRepeated(String str){
        char[] c = str.toCharArray();
        Set<Character> set = new HashSet<>();
        for(int i=0;i<c.length;i++){
            if(!set.add(c[i])){
                return true;
            }
        }
        return false;
    }

    public int lengthOfLongestSubstring2(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        
        int l = 0, r = 0;
        Map<Character, Integer> map = new HashMap<>();
        char[] str = s.toCharArray();
        int max = 1;
        for(;r<str.length;r++){
            if(map.containsKey(str[r])){
                l = Math.max(l,map.get(str[r])+1);
            }
            map.put(str[r],r);
            max = Math.max(max,r-l+1);
        }
        return max;
    }
}