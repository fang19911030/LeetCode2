public class Solution {
    /**
     * @param stones a list of stones' positions in sorted ascending order
     * @return true if the frog is able to cross the river or false
     */
    public boolean canCross(int[] stones) {
        // Write your code here
        if(stones == null || stones.length == 1){
            return true;
        }
        int[][] dp = new int[stones.length][stones.length+1];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<stones.length;i++){
            map.put(stones[i],i);
        }
        if(stones[1] != 1){
            return false;
        }
        return dfs(stones,dp,1,1,map);
    }
    
    private boolean dfs(int[]stones, int[][]dp,int index, int pre,Map<Integer,Integer>map){
        if(index>=stones.length-1){
            return true;
        }
        if(dp[index][pre-1]!= 0){
            if(dp[index][pre-1]==1){
                return true;
            }else{
                return false;
            }
        }
        boolean res = false;
        for(int i=pre+1;i>=Math.max(pre-1,1);i--){
            if(map.containsKey(stones[index]+i)){
                res = res || dfs(stones,dp,map.get(stones[index]+i),i,map);
            }
        }
        if(res == true){
            dp[index][pre-1] = 1;
        }else{
            dp[index][pre-1] = -1;
        }
        return res;
        
    }
}