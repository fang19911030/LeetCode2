class Solution {
    public int maxProduct(String[] words) {
        if(words == null || words.length == 0){
            return 0;
        }
        int max = 0;
        Map<String, List<String>> map = groupWords(words);
        sortList(map);
        for(String str1 : map.keySet()){
            for(String str2 : map.keySet()){
                if(isValid(str1, str2)){
                    List<String> l1 = map.get(str1);
                    List<String> l2 = map.get(str2);
                    max = Math.max(max, l1.get(l1.size()-1).length()* l2.get(l2.size()-1).length());
                }
            }
        }
        return max;
        
    }
    
    private Map<String, List<String>> groupWords(String[] words){
        Map<String, List<String>> map = new HashMap<>();
        for(int i=0; i<words.length; i++){
            String key = getKey(words[i]);
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(words[i]);
        }
        return map;
    }
    
    private String getKey(String str){
        char[] arr = str.toCharArray();
        Set<Character> set = new HashSet<Character>();
        for(int i=0;i<arr.length; i++){
            set.add(arr[i]);
        }
        List<Character> chars = new ArrayList<>(set);
        Collections.sort(chars);
        StringBuilder sb = new StringBuilder();
        for(char c:chars){
            sb.append(c);
        }
        return sb.toString();
    }
    
    private void sortList(Map<String,List<String>> map){
        for(String k : map.keySet()){
            List<String> list = map.get(k);
            Collections.sort(list, (a,b)->a.length()-b.length());
        }
    }
    
    private boolean isValid(String a, String b){
        Set<Character> set = new HashSet<>();
        char[] arr = a.toCharArray();
        for(int i=0; i<arr.length; i++){
            set.add(arr[i]);
        }
        char[] arr2 = b.toCharArray();
        for(int i=0; i<arr2.length; i++){
            if(set.contains(arr2[i])){
                return false;
            }
        }
        return true;
    }
}