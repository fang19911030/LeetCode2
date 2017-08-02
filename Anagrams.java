public class Solution {
    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public List<String> anagrams(String[] strs) {
        // write your code here
        List<String> res = new ArrayList<>();
        if(strs == null || strs.length<=1){
            return res;
        }
        boolean[] groupOrNot = new boolean[strs.length];
        for(int i=0;i<strs.length;i++){
            if(groupOrNot[i]) continue;
            for(int j=i+1;j<strs.length;j++){
                if(groupOrNot[j]) continue;
                if(isValid(strs[i],strs[j])){
                    if(!groupOrNot[i]){
                        groupOrNot[i] = true;
                        res.add(strs[i]);
                    }
                    if(!groupOrNot[j]){
                        res.add(strs[j]);
                        groupOrNot[j] = true;
                    }
                }
            }
        }
        return res;
        
    }
    
    private boolean isValid(String a, String b){
        if(a.length() != b.length()){
            return false;
        }
        int[] arr = new int[26];
        char[] s1 = a.toCharArray();
        char[] s2 = b.toCharArray();
        for(int i=0;i<s1.length;i++){
            arr[s1[i]-'a']++;
            arr[s2[i]-'a']--;
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i] != 0){
                return false;
            }
        }
        return true;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs==null || strs.length == 0){
            return new ArrayList<List<String>>();
        }
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        //Arrays.sort(strs);
        for (String s:strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            if(!map.containsKey(keyStr))
                map.put(keyStr, new ArrayList<String>());
            map.get(keyStr).add(s);
        }
        
    //  for(String key: map.keySet()) {
    //      Collections.sort(map.get(key));
    //  }
        return new ArrayList<List<String>>(map.values());
    }
}