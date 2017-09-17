class Solution {
    public String minWindow(String s, String t) {
        String ans="";
        int[] ascii = new int[128];
        for(char e: t.toCharArray()){
            ascii[e]++;
        }
        
        int counter = t.length(), begin = 0, end = 0, minLen = Integer.MAX_VALUE, head = 0;
        while(end < s.length()){
            if(ascii[s.charAt(end)]>0){
                counter--;
            }
            ascii[s.charAt(end)]--;
            end++;
            while(counter == 0){
                if(end - begin < minLen){
                    head = begin;
                    minLen = end-begin;
                }
                ascii[s.charAt(begin)]++;
                if(ascii[s.charAt(begin)] > 0){
                    counter++;
                }
                begin++;
            }
            
        }
        if( minLen != Integer.MAX_VALUE)
            ans = s.substring(head,head+minLen);
        return ans;
    }
}