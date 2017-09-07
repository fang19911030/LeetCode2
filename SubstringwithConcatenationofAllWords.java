class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if(s == null || s.length() == 0 || words == null || words.length == 0){
            return res;
        }
        int subLength = words[0].length() * words.length;
        int l = words[0].length();
        Set<String> dict = new HashSet<>(Arrays.asList(words));
        Map<String, Integer> countOfWord = new HashMap<>();
        for(String str: words){
            countOfWord.put(str,countOfWord.getOrDefault(str,0)+1);
        }
        for(int i=0;i+subLength-1<s.length();i++){
            String sub = s.substring(i,i+subLength);
            //Set<String> visited = new HashSet<>();
            Map<String,Integer> count = new HashMap<>(countOfWord);
            if(isValid(sub,count,0,l)){
                res.add(i);
            }
        }
        return res;
    }
    
    private boolean isValid(String str,Map<String,Integer> map, int index, int l){
        if(index >= str.length()){
            return true;
        }
        
        String sub = str.substring(index,index+l);
        if(map.containsKey(sub)){
            if(map.get(sub) == 1){
                map.remove(sub);
            }else{
                map.put(sub, map.get(sub)-1);
            }
            if(isValid(str,map,index+l,l)){
                return true;
            }
        }
        return false;
    }

    public static List<Integer> findSubstring(String S, String[] L) {
        List<Integer> res = new ArrayList<Integer>();
        if (S == null || L == null || L.length == 0) return res;
        int len = L[0].length(); // length of each word
        
        Map<String, Integer> map = new HashMap<String, Integer>(); // map for L
        for (String w : L) map.put(w, map.containsKey(w) ? map.get(w) + 1 : 1);
        
        for (int i = 0; i <= S.length() - len * L.length; i++) {
            Map<String, Integer> copy = new HashMap<String, Integer>(map);
            for (int j = 0; j < L.length; j++) { // checkc if match
                String str = S.substring(i + j*len, i + j*len + len); // next word
                if (copy.containsKey(str)) { // is in remaining words
                    int count = copy.get(str);
                    if (count == 1) copy.remove(str);
                    else copy.put(str, count - 1);
                    if (copy.isEmpty()) { // matches
                        res.add(i);
                        break;
                    }
                } else break; // not in L
            }
        }
        return res;
    }
}