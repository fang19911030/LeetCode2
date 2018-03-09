class Solution {
    public int countBinarySubstrings(String s) {
        int preRunLength = 0， curRunLength = 1， res = 0;
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i) == s.charAt(i-1)) curRunLength++;
            else{
                preRunLength = curRunLength;
                curRunLength = 1;
            }
            if(preRunLength>=curLength) res ++;
        }
        return res;
    }
}