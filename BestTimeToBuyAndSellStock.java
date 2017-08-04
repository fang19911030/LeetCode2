public class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        if(prices== null || prices.length==0){
            return 0;
        }
        int res = Integer.MIN_VALUE;
        int lowBuy = Integer.MAX_VALUE;
        int highSell = Integer.MIN_VALUE;
        for(int i=0;i<prices.length;i++){
            int cur = prices[i];
            if(cur<lowBuy){
                lowBuy = cur;
                highSell = cur;
            }else{
                highSell = Math.max(highSell, cur);
            }
            res = Math.max(res,highSell-lowBuy);
        }
        return res;
    }
}