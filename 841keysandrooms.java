class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if(rooms== null || rooms.size() == 0) return true;
        int[] unvisited = {rooms.size()-1};
        Set<Integer> visited = new HashSet<>();
        return dfs(rooms, 0, visited, unvisited);
    }
    
    private boolean dfs(List<List<Integer>> rooms, int cur, Set<Integer> visited, int[] unvisited){
        if(unvisited[0] == 0){
            return true;
        }
        if(visited.contains(cur)){
            return false;
        }
        visited.add(cur);
        List<Integer> nxt = rooms.get(cur);
        for(Integer t : nxt){
            if(!visited.contains(t)){
                unvisited[0]--;
                if(dfs(rooms, t, visited, unvisited)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if(rooms == null || rooms.size() == 0) return true;
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(0);
        visited.add(0);
        while(!queue.isEmpty()){
            if(visited.size() == rooms.size()){
                return true;
            }
            int cur = queue.poll();
            List<Integer> nxt = rooms.get(cur);
            for(Integer t: nxt){
                if(!visited.contains(t)){
                    visited.add(t);
                    queue.offer(t);
                }
            }
        }
        return false;
    }
}