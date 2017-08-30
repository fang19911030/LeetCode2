class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> map = new HashMap<>();
        if(wordList == null || wordList.size() == 0){
            return 0;
        }
        wordList.add(beginWord);
        initMap(wordList, map);
        if(!map.containsKey(endWord)){
            return 0;
        }
        int res = 1;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> visited = new HashSet<>();
        while(!queue.isEmpty()){
            Queue<String> next = new LinkedList<>();
            while(!queue.isEmpty()){
                String cur = queue.poll();
                visited.add(cur);
                if(cur.equals(endWord)){
                    return res;
                }
                List<String> list = map.get(cur);
                for(String str:list){
                    if(!visited.contains(str))
                        next.offer(str);
                }
            }
            queue = next;
            res++;
        }
        return 0;
        
        
    }
    
    private boolean isOnediff(String a, String b){
        char[] str1 = a.toCharArray();
        char[] str2 = b.toCharArray();
        int diff = 0;
        for(int i=0;i<str1.length;i++){
            if(str1[i]!=str2[i]){
                diff++;
            }
        }
        return diff==1 ;
    }
    
    private void initMap(List<String> wordList, Map<String, List<String>> map){
        for(int i=0;i<wordList.size()-1;i++){
            for(int j=i+1;j<wordList.size();j++){
                if(isOnediff(wordList.get(i), wordList.get(j))){
                    String a = wordList.get(i);
                    String b = wordList.get(j);
                    if(!map.containsKey(a)){
                        List<String> list = new ArrayList<>();
                        map.put(a,list);
                    }
                    if(!map.containsKey(b)){
                        List<String> list = new ArrayList<>();
                        map.put(b,list);
                    }
                    map.get(a).add(b);
                    map.get(b).add(a);
                }
            }
        }
    }
}