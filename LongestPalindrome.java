public class Solution {
    /**
     * @param s a string which consists of lowercase or uppercase letters
     * @return the length of the longest palindromes that can be built
     */
    public int longestPalindrome(String s) {
        // Write your code here
        if(s == null || s.length() == 0){
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        for(int i=0;i<arr.length;i++){
            char cur = arr[i];
            if(map.containsKey(cur)){
                map.put(cur,map.get(cur)+1);
            }else{
                map.put(cur,1);
            }

        }
        Collection<Integer> set = map.values();
        int res = 0;
        boolean odd = false;
        for(Integer t:set){
            if(t%2 == 0){
                res += t;
            }else{
                res += (t/2)*2;
                odd = true;
            }

        }
        if(odd){
            return ++res;
        }else{
            return res;
        }
        
    }
}