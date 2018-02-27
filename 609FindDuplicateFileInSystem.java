class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> res = new ArrayList<>();
        if(paths == null || paths.length == 0){
            return res;
        }
        Map<String, List<String>> map = new HashMap<>();
        groupFile(paths, map);
        
        for(String s : map.keySet()){
            if(map.get(s).size()>1){
                res.add(map.get(s));
            }
        }
        return res;
    }
    
    private void groupFile(String[] paths, Map<String,List<String>> map){
        if(paths == null || paths.length == 0){
            return;
        }
        
        for(int i=0; i<paths.length; i++){
            String cur = paths[i];
            String[] partitions = cur.split(" ");
            String folder = partitions[0];
            Map<String, List<String>> contentToFile = getMap(partitions);
            for(String s:contentToFile.keySet()){
                if(!map.containsKey(s)){
                    map.put(s, new ArrayList<String>());
                }
                List<String> fileName = contentToFile.get(s);
                for(String ss : fileName){
                    String fullPath = folder+"/"+ss;
                    map.get(s).add(fullPath);
                }
            }
        }
        //return map;
    }
    
    private Map<String, List<String>> getMap(String[] arr){
        Map<String, List<String>> res = new HashMap<>();
        for(int i=1; i<arr.length; i++){
            int idx = arr[i].indexOf("(");
            String content = arr[i].substring(idx+1, arr[i].length()-1);
            String fileName = arr[i].substring(0,idx);
            if(!res.containsKey(content)){
                res.put(content, new ArrayList<String>());
            }
            res.get(content).add(fileName);
        }
        return res;
    }
}