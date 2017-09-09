class Solution {
    int[][] neighbours ={{-1,0},{1,0},{0,1},{0,-1},{1,1},{-1,1},{1,-1},{-1,-1}};
    public void gameOfLife(int[][] board) {
        int[][] copy = copyBoard(board);
        for(int i=0;i<copy.length;i++){
            for(int j=0;j<copy[0].length;j++){
                board[i][j] = update(copy,i,j);
            }
        }
    }
    
    private int[][] copyBoard(int[][] board){
        int[][] res = new int[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                res[i][j] = board[i][j];
            }
        }
        return res;
    }
    
    private int update(int[][] state, int r, int c){
        if(state[r][c] == 0){
            int count = countLive(state, r, c);
            if(count == 3){
                return 1;
            }else{
                return 0;
            }
        }else{
            int count = countLive(state, r, c);
            if(count < 2) return 0;
            if(count ==2 || count == 3) return 1;
            else{
                return 0;
            }
        }
    }
    
    private int countLive(int[][] start, int r, int c){
        int res = 0;
        for(int[] n:neighbours){
            int neighbourR = r + n[0];
            int neighbourC = c + n[1];
            if (neighbourR<0 || neighbourR>=start.length || neighbourC < 0 || neighbourC>=start[0].length){
                continue;
            }else if(start[neighbourR][neighbourC]==1){
                res++;
            }
        }
        return res;
    }
}