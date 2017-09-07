class Solution {
    public int countBattleships(char[][] board) {
        if(board == null || board.length == 0){
            return 0;
        }
        
        int count  = 0;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(!visited[i][j] && board[i][j]=='X'){
                    count++;
                    dfs(board,visited,i,j);
                }
            }
        }
        return count;
    }
    
    private void dfs(char[][] board, boolean[][] visited, int r, int c){
        if(r<0 || r == board.length || c<0 || 
           c== board[0].length || board[r][c] == '.' || visited[r][c]){
            return;
        }
        
        visited[r][c] = true;
        dfs(board, visited,r+1,c);
        dfs(board, visited,r,c+1);
    }
}