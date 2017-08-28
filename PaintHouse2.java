class Solution {
    public int minCostII(int[][] costs) {
        if(costs == null || costs.length == 0|| costs[0].length == 0){
            return 0;
        }
        
        int n =costs.length, k = costs[0].length;
        int preMin = 0, preMinInd = -1, preSecMin = 0;
        for(int i=0;i<n;i++){
            int min = Integer.MAX_VALUE, minInd = -1, secMin = Integer.MAX_VALUE;
            for(int j=0;j<k;j++){
                int val = costs[i][j] + (j==preMinInd? preSecMin:preMin);
                if(val<min){
                    secMin = min;
                    min = val;
                    minInd = j;
                }else if(val<secMin){
                    secMin = val;
                }
            }
            preMin = min;
            preMinInd = minInd;
            preSecMin = secMin;
        }
        return preMin;
    }
}