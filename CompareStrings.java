public class Solution {
    /*
     * @param A: A string
     * @param B: A string
     * @return: if string A contains all of the characters in B return true else return false
     */
    public boolean compareStrings(String A, String B) {
        // write your code here
        Map<Character,Integer> map1 = new HashMap<>();
        Map<Character, Integer>map2 = new HashMap<>();
        initMap(A,map1);
        initMap(B,map2);
        for(Character c:map2.keySet()){
            if(!map1.containsKey(c) || map1.get(c)<map2.get(c)){
                return false;
            }
        }
        return true;
    }
    
    private void initMap(String s, Map<Character,Integer>map){
        char[] str = s.toCharArray();
        for(int i=0;i<str.length;i++){
            if(map.containsKey(str[i])){
                map.put(str[i],map.get(str[i])+1);
            }else{
                map.put(str[i],1);
            }
        }
    }
}