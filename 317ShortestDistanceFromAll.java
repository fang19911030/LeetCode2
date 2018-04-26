class Solution {
    int[] dx = {1,0,-1,0}, dy = {0,1, 0, -1};
    public int shortestDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dist = new int[m][n];
        
        List<Tuple> buildings = new ArrayList<>();
        
        for(int i=0; i< m ; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1)
                    buildings.add(new Tuple(i, j, 0));
                grid[i][j] = -grid[i][j];
            }
        }
        
        for(int k = 0; k<buildings.size(); ++k){
            bfs(buildings.get(k), k, dist, grid, m, n);
        }
        
        int ans = -1;
        
        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                if(grid[i][j] == buildings.size() && (ans<0 || dist[i][j]<ans)){
                    ans = dist[i][j];
                }
            }
        }
        return ans;
    }
    
    public void bfs(Tuple root, int k, int[][] dist, int[][] grid, int m, int n){
        Queue<Tuple> q = new ArrayDeque<>();
        q.add(root);
        while(!q.isEmpty()){
            Tuple b = q.poll();
            dist[b.x][b.y] += b.dist;
            for(int i=0;i<4; i++){
                int x = b.x + dx[i], y = b.y + dy[i];
                if(y>=0 && x >=0 && y < n && x < m && grid[x][y] == k){
                    grid[x][y] = k+1;
                    q.add(new Tuple(x, y, b.dist+1));
                    
                }
            }
        }
    }
    class Tuple {
    public int y;
    public int x;
    public int dist;

    public Tuple(int x, int y, int dist) {
        this.y = y;
        this.x = x;
        this.dist = dist;
    }
}
}