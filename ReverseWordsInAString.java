public class Solution {
    /*
     * @param s: A string
     * @return: A string
     */
    public String reverseWords(String s) {
        // write your code here
        if(s == null || s.length() ==0){
            String res = "";
            return res;
        }
        String[] strs = s.split(" ");
        int i = 0;
        int j = strs.length-1;
        while(i<=j){
            String t = strs[i];
            strs[i] = strs[j];
            strs[j] = t;
            i++;
            j--;
        }
        String res ="";
        if(strs.length == 0){
            return res;
        }
        
        res = strs[0];
        for(int t=1;t<strs.length;t++){
            res +=" "+ strs[t];
        }
        return res;
        
        
    }
}