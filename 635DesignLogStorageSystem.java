class LogSystem {
    List<String[]> timestamps = new LinkedList<>();
    List<String> units = Arrays.asList("Year", "Month", "Day", "Hour", "Minute", "Second");
    int[] indices = new int[]{4, 7, 10, 13, 16, 19};
    public LogSystem() {
        
    }
    
    public void put(int id, String timestamp) {
        timestamps.add(new String[]{Integer.toString(id), timestamp});
    }
    
    public List<Integer> retrieve(String s, String e, String gra) {
        List<Integer> res = new LinkedList<>();
        int idx = indices[units.indexOf(gra)];
        for(String[] timestamp:timestamps){
            String cur = timestamp[1].substring(0, idx);
            String s_sub = s.substring(0, idx);
            String e_sub = e.substring(0, idx);
            if(cur.compareTo(s_sub)>=0 && cur.compareTo(e_sub)<=0){
                res.add(Integer.parseInt(timestamp[0]));
            }
        }
        return res;
    }
}

class LogSystem {
    
    private String min, max;
    private HashMap<String, Integer> map;
    private TreeMap<String, LinkedList<Integer>> logs;

    public LogSystem() {
        min = "2000:01:01:00:00:00";
        max = "2017:12:31:23:59:59";
        map = new HashMap<>();
        map.put("Year", 4);
        map.put("Month", 7);
        map.put("Day", 10);
        map.put("Hour", 13);
        map.put("Minute", 16);
        map.put("Second", 19);
        logs = new TreeMap<>();
    }
    
    public void put(int id, String timestamp) {
        if(!logs.containsKey(timestamp)) logs.put(timestamp, new LinkedList<>());
        logs.get(timestamp).add(id);
    }
    
    public List<Integer> retrieve(String s, String e, String gra) {
        int index = map.get(gra);
        String start = s.substring(0, idx)+min.substring(idx);
        String end = e.substring(0, idx) + max.substring(idx);
        NavigableMap<String, LinkedList<Integer>> sub = logs.subMap(start, true, end, true);
        LinkedList<Integer> res = new LinkedList<>();
        for(Map.Entry<String, LinkedList<Integer>> entry : sub.entrySet()){
            ans.addAll(entry.getValue());
        }
        return ans;
    }
}