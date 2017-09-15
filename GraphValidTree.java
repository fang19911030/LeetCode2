class Solution {
    class UnionFind{
        int[] parent;
        UnionFind(int n){
            parent = new int[n];
            for(int i=0;i<n;i++){
                parent[i] = i;
            }
        }
        
        public int find(int x){
            return compressed_find(x);
        }
        
        public int compressed_find(int x){
            int x_parent = parent[x];
            while(x_parent != parent[x_parent]){
                x_parent = parent[x_parent];
            }
            
            int temp = -1;
            int t_parent = parent[x];
            while(t_parent != parent[t_parent]){
                temp = parent[t_parent];
                parent[t_parent] = x_parent;
                t_parent = temp;
            }
            return x_parent;
        }
        
        public void union(int x, int y){
            int x_parent = find(x);
            int y_parent = find(y);
            if(x_parent != y_parent){
                parent[x_parent] = y_parent;
            }
        }
    }
    
    public boolean validTree(int n, int[][] edges){
        if(n-1 != edges.length || n==0){
            return false;
        }
        UnionFind uf = new UnionFind(n);
        for(int i=0;i< edges.length;i++){
            if(uf.find(edges[i][0]) == uf.find(edges[i][1])){
                return false;
            }
            uf.union(edges[i][0], edges[i][1]);
        }
        return true;
    }
}


class Solution {
    public boolean validTree(int n, int[][] edges) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            ArrayList<Integer> list = new ArrayList<Integer>();
            map.put(i, list);
        }
        
        for(int[] edge : edges){
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        
        boolean[] visited = new boolean[n];
        if(!helper(0,-1,map,visited)){
            return false;
        }
        
        for(boolean b: visited){
            if(!b){
                return false;
            }
        }
        return true;
    }
    
    private boolean helper(int index, int pre, HashMap<Integer, ArrayList<Integer>>map,boolean[] visited ){
        if(visited[index]){
            return false;
        }
        visited[index] = true;
        for(int t:map.get(index)){
            if(t!=pre && !helper(t,index,map,visited)){
                return false;
            }
        }
        return true;
        
    }
}