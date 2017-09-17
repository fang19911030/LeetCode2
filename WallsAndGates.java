class Solution {
    private final int INF = 2147483647;
    private int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};
    // int X, Y;
    public void wallsAndGates(int[][] rooms) {
        if(rooms == null){
            return;
        }        
        for(int i=0;i<rooms.length;i++){
            for(int j=0;j<rooms[0].length;j++){
                if(rooms[i][j] != 0 && rooms[i][j] != -1){
                    int dist = bfs(rooms, i,j);
                    rooms[i][j] = dist == Integer.MAX_VALUE? INF:dist;
                }
            }
        }
    }
    
    private int bfs(int[][] rooms, int r, int c){
        Position start = new Position(r,c);
        Queue<Position> queue = new LinkedList<>();
        queue.offer(start);
        int count = 0;
        boolean[][] visited = new boolean[rooms.length][rooms[0].length];
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                Position cur = queue.poll();
                visited[cur.x][cur.y] = true;
                for(int[] dict: directions){
                    int nextX = cur.x + dict[0];
                    int nextY = cur.y + dict[1];
                    if(isValidStep(nextX, nextY,rooms,visited)){
                        if(rooms[nextX][nextY] == 0){
                            return count+1;
                        }else{
                            Position next = new Position(nextX,nextY);
                            queue.offer(next);
                        }
                    }

                }
            }
            count++;
        }
        return Integer.MAX_VALUE;
    }
    
    private boolean isValidStep(int x, int y,int[][] rooms,boolean[][]visited){
        return x>=0 && x<rooms.length && y>= 0 && y<rooms[0].length && rooms[x][y]!=-1 && !visited[x][y];
    }
    
    class Position{
        int x;
        int y;
        Position(int r, int c){
            x = r;
            y = c;
        }
    }

    public void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0 || rooms[0].length == 0) return;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) queue.add(new int[]{i, j});
            }
        }
        while (!queue.isEmpty()) {
            int[] top = queue.remove();
            int row = top[0], col = top[1];
            if (row > 0 && rooms[row - 1][col] == Integer.MAX_VALUE) {
                rooms[row - 1][col] = rooms[row][col] + 1;
                queue.add(new int[]{row - 1, col});
            }
            if (row < rooms.length - 1 && rooms[row + 1][col] == Integer.MAX_VALUE) {
                rooms[row + 1][col] = rooms[row][col] + 1;
                queue.add(new int[]{row + 1, col});
            }
            if (col > 0 && rooms[row][col - 1] == Integer.MAX_VALUE) {
                rooms[row][col - 1] = rooms[row][col] + 1;
                queue.add(new int[]{row, col - 1});
            }
            if (col < rooms[0].length - 1 && rooms[row][col + 1] == Integer.MAX_VALUE) {
                rooms[row][col + 1] = rooms[row][col] + 1;
                queue.add(new int[]{row, col + 1});
            }
        }
    }
    
}