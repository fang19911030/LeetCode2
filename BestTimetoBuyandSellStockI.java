public class Solution {
    public int maxProfit(int[] prices) {
        // write your code here
        int res = 0;
        if(prices == null || prices.length == 0){
            return res;
        }
        int lowBuy = Integer.MAX_VALUE;
        int highSell = Integer.MIN_VALUE;
        for(int i=0;i<prices.length;i++){
            int cur = prices[i];
            if(cur<lowBuy){
                lowBuy = cur;
                highSell = cur;
            }else{
                highSell = cur;
            }
            if(highSell-lowBuy!=0){
                res += highSell-lowBuy;
                lowBuy = cur;
                highSell = cur;
                
            }
        }
        return res;
    }
}