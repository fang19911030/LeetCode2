public class Solution {
    /**
     * @param board a 2D board containing 'X' and 'O'
     * @return void
     */
    public void surroundedRegions(char[][] board) {
        // Write your code here

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                boolean[][] visited = new boolean[board.length][board[0].length];
                if(board[i][j]=='O'){
                    if(isSurrounded(board,i,j,visited)){
                        board[i][j] = 'X';        
                    }
                }
            }
        }
    }
    
    private boolean isSurrounded(char[][]board, int i,int j,boolean[][]visited){
        if(i<0 || i==board.length || j<0 || j==board[0].length){
            return false;
        }
        if(visited[i][j]) return true;
        visited[i][j] = true;
        if(board[i][j] =='X'){
            return true;
        }
        boolean up = isSurrounded(board,i-1,j,visited);
        boolean down = isSurrounded(board,i+1,j,visited);
        boolean left = isSurrounded(board,i,j-1,visited);
        boolean right = isSurrounded(board,i,j+1,visited);
        return up && down && left && right;
    }
}