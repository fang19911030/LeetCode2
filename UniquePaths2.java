public class Solution {
    /*
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        int r = obstacleGrid.length;
        int c = obstacleGrid[0].length;
        int[][] dp = new int[r][c];
        int i=0;
        int j = 0;
        while(j<c){
            if(obstacleGrid[0][j] ==1){
                while(j<c){
                    dp[0][j] = -1;
                    j++;
                }
                break;
            }
            dp[0][j] = 1;
            j++;
        }
        
        while(i<r){
            if(obstacleGrid[i][0] == 1){
                while(i<r){
                    dp[i][0] = -1;
                    i++;
                }
                break;
            }
            dp[i][0] = 1;
            i++;
        }
        
        for(int x=1;x<r;x++){
            for(int y=1;y<c;y++){
                if(obstacleGrid[x][y]!= 1){
                    if(dp[x-1][y]==-1 && dp[x][y-1]==-1){
                        dp[x][y] = -1;
                    }else if(dp[x-1][y] == -1){
                        dp[x][y] = dp[x][y-1];
                    }else if(dp[x][y-1] == -1){
                        dp[x][y] = dp[x-1][y];
                    }else{
                        dp[x][y] = dp[x-1][y]+dp[x][y-1];
                    }
                }else{
                    dp[x][y] = -1;
                }
            }
        }
        
        return dp[r-1][c-1]==-1? 0:dp[r-1][c-1];
    }
};