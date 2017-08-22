public class Solution {
    /**
     * @param costs n x 3 cost matrix
     * @return an integer, the minimum cost to paint all houses
     */
     int res = Integer.MAX_VALUE;
    public int minCost(int[][] costs) {
        // Write your code here
        if(costs == null || costs.length==0){
            return 0;
        }
        
        help(costs,0,-1,0);
        return res;
    }
    
    private void help(int[][] costs,int cur, int preColor, int cost){
        if(cur == costs.length){
            res = Math.min(res,cost);
            return;
        }
        
        if(preColor == -1){
            for(int i=0;i<costs[cur].length;i++){
                help(costs,cur+1,i,cost+costs[cur][i]);
            }
        }
        
        for(int i=0;i<costs[cur].length;i++){
            if(i!=preColor){
                help(costs,cur+1,i,cost+costs[cur][i]);
            }
        }
        
    }
}