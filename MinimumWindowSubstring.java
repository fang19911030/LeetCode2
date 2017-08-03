public class Solution {
    /**
     * @param source: A string
     * @param target: A string
     * @return: A string denote the minimum window
     *          Return "" if there is no such a string
     */
    public String minWindow(String source, String target) {
        // write your code
        if(target == null || source == null || target.length() > source.length() 
        || target.length() == 0 || source.length() == 0){
            return "";
        }
        
        Map<Character, Integer> map = new HashMap<>();
        char[] targetChar = target.toCharArray();
        char[] sourceChar = source.toCharArray();
        for(int i=0;i<targetChar.length;i++){
            char c = targetChar[i];
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }else{
                map.put(c,1);
            }
        }
        String res ="";
        for(int t = target.length(); t<=source.length();t++){
            for(int i=0;i+t-1<source.length();i++){
                int j = i+t-1;
                if(isValid(sourceChar,i,j,map)){
                    res = source.substring(i,i+t);
                    return res;
                }
            }
        }
        return res;
        
    }
    
    private boolean isValid(char[] s, int left, int right,Map<Character,Integer>map){
        Map<Character, Integer> map2 = new HashMap<>();
        for(int i=left;i<=right;i++){
            char c = s[i];
            if(map2.containsKey(c)){
                map2.put(c,map2.get(c)+1);
            }else{
                map2.put(c,1);
            }
        }
        
        for(Character c:map.keySet()){
            if(!map2.containsKey(c) || map2.get(c)<map.get(c)){
                return false;
            }
        }
        return true;
    }
}