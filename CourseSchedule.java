class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] visited = new boolean[numCourses];
        boolean[] onStack = new boolean[numCourses];
        Set<Integer>[] graph = new Set[numCourses];
        for(int i=0;i<graph.length;i++){
            graph[i] = new HashSet<>();
        }
        for(int i=0;i<prerequisites.length;i++){
            int s = prerequisites[i][0];
            int t = prerequisites[i][1];
            graph[s].add(t);
        }
        for(int i=0;i<numCourses;i++){
            if(!visited[i]){
                if(hasCycle(graph,visited,onStack,i)){
                    return false;
                }
            }
        }
        for(int i=0;i<numCourses;i++){
            if(!visited[i]){
                return false;
            }
        }
        return true;
    }
    
    private boolean hasCycle(Set<Integer>[] graph, boolean[] visited, boolean[] onStack, int index){
        visited[index] = true;
        onStack[index] = true;
        boolean res = false;
        for(Integer t:graph[index]){
            if(onStack[t]){
                res = true;
            }else{
                if(!visited[t]){
                    res = res || hasCycle(graph,visited,onStack,t);
                }
            }
        }
        onStack[index] = false;
        return res;
    }
}