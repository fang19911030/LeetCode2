class Solution {
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        
        List<String> substrings = getSubstrings(s);
        Set<String> set = new HashSet<>();
        int res = 0;
        for(String ss :substrings){
            if(!set.contains(ss) && !isValid(ss)){
                continue;
            }else{
                if(set.contains(ss)){
                    res++;
                }else{
                    set.add(ss);
                    res++;
                }
            }
        }
        return res;
    }
    
    private boolean isValid(String s){
        char[] arr = s.toCharArray();
        int l = 0;
        int r = arr.length-1;
        while(l<r){
            if(arr[l] != arr[r]){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
    
    private List<String> getSubstrings(String s){
        List<String> res= new ArrayList<>();
        for(int l=1;l<=s.length(); l++){
            for(int i=0; i<=s.length()-l; i++){
                res.add(s.substring(i,i+l));
            }
        }
        return res;
    }
}


class Solution {
    int count = 1;
    public int countSubstrings(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        
        for(int i=0; i< s.length()-1; i++){
            checkPalindrome(s, i, i);
            checkPalindrome(s, i, i+1);
        }
        
        return count;
    }
    
    private void checkPalindrome(String s, int l, int r){
        while(l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)){
            count++;
            l--;
            r++;
        }
    }
}