public class Solution {
    /**
     * @param s a string
     * @param t a string
     * @return true if the characters in s can be replaced to get t or false
     */
    public boolean isIsomorphic(String s, String t) {
        // Write your code here
        if(s == null && t == null || s.length()==0 && t.length()==0){
            return true;
        }
        if(s == null || t== null || s.length()==0 || t.length()==0){
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        for(int i=0;i<s1.length;i++){
            char key = s1[i];
            char value = t1[i];
            if(map.containsKey(key)){
                if(value != map.get(key)){
                    return false;
                }
            }else{
                if(map.containsValue(value)){
                    return false;
                }
                map.put(key, value);
            }
        }
        return true;
    }
}