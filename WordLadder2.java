class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>>res = new ArrayList<>();
        Set<String> wordDict = new HashSet<>(wordList);
        Map<String,Integer> distance = new HashMap<>();
        Map<String, List<String>> neighbour = new HashMap<>();
        distance.put(beginWord, 1);
        wordDict.add(beginWord);
        bfs(beginWord, endWord, neighbour, distance,wordDict);
        List<String> cur = new ArrayList<>();
        dfs(beginWord, endWord, neighbour, distance, res, cur);
        return res;
    }
    
    private void bfs(String beginWord, String endWord, Map<String,List<String>> neighbour, 
                     Map<String, Integer> distance, Set<String>wordDict){
        Queue<String> queue = new LinkedList<>();
        for(String str: wordDict){
            neighbour.put(str, new ArrayList<>());
        }
        queue.offer(beginWord);
        while(!queue.isEmpty()){
            int size = queue.size();
            boolean found = false;
            for(int i=0;i<size;i++){
                String cur = queue.poll();
                List<String> next = generateNext(cur, wordDict);
                for(String str:next){
                    neighbour.get(cur).add(str);
                    if(!distance.containsKey(str)){
                        distance.put(str, distance.get(cur)+1);
                        if(str.equals(endWord)){
                            found = true;
                        }else{
                            queue.offer(str);
                        }
                    }
                }

            }
            if(found == true)
                break;
        }
    }
    
    private List<String> generateNext(String cur, Set<String> wordDict){
        char[] str = cur.toCharArray();
        List<String> res = new ArrayList<>();
        for(int i=0;i<str.length;i++){
            for(char c = 'a'; c<='z';c++){
                char old = str[i];
                str[i] = c;
                String next = String.valueOf(str);
                if(wordDict.contains(next) && !next.equals(cur)){
                    res.add(next);
                }
                str[i] = old;
            }
        }
        return res;
    }
    
    private void dfs(String cur, String end, Map<String,List<String>> neighbour, Map<String, Integer>distance,
                    List<List<String>> res, List<String> path){
        path.add(cur);
        if(cur.equals(end)){
            List<String> r = new ArrayList<>(path);
            res.add(r);
        }else{
            for(String str: neighbour.get(cur)){
                if(distance.get(str) == distance.get(cur)+1){
                    dfs(str,end,neighbour, distance, res,path);
                }
            }
        }
        path.remove(path.size()-1);
    }
}