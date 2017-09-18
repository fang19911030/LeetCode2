class Solution {
    public boolean validPalindrome(String s) {
        if(s == null || s.length() == 0){
            return true;
        }
        char[] arr = s.toCharArray();
        int l = 0;
        int r = arr.length -1;
        while(l<=r){
            if(arr[l]== arr[r]){
                l++;
                r--;
            }else{
                if(valid(s,l+1,r) || valid(s,l,r-1)){
                    return true;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean valid(String s, int l, int r){
        if(l>=s.length() || l<0){
            return false;
        }
        if(r<0 ||r >=s.length()){
            return false;
        }
        
        char[] arr = s.toCharArray();
        while(l<=r){
            if(arr[l] != arr[r]){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}