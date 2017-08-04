public class Solution {
    public int maxProfit(int[] prices) {
        // write your code here
        
        // int[] diff = new int[prices.length];
        // diff[0] = 0;
        // for(int i=1;i<prices.length;i++){
        //     diff[i] = prices[i]-prices[0];
        // }
        
        int max1 = 0;
        int max2 = 0;
        int res = 0;
        for(int i=0;i<prices.length;i++){
            max1 = findMax(prices,0,i);
            max2 = findMax(prices,i+1,prices.length-1);
            res = Math.max(res,max1+max2);
        }
        return res;
    }
    
    public int findMax(int[] arr, int left, int right){
        if(left >= right){
            return 0;
        }
        int res = 0;
        int lowBuy = Integer.MAX_VALUE;
        int highSell = Integer.MIN_VALUE;
        for(int i=left;i<=right;i++){
            int cur = arr[i];
            if(cur<lowBuy){
                lowBuy = cur;
                highSell = cur;
            }else{
                highSell = cur;
            }
            res = Math.max(res,highSell-lowBuy);
        }
        return res;
    }
    public int maxProfit(int[] prices) {
        int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
        int release1 = 0, release2 = 0;
        for(int i:prices){                              // Assume we only have 0 money at first
            release2 = Math.max(release2, hold2+i);     // The maximum if we've just sold 2nd stock so far.
            hold2    = Math.max(hold2,    release1-i);  // The maximum if we've just buy  2nd stock so far.
            release1 = Math.max(release1, hold1+i);     // The maximum if we've just sold 1nd stock so far.
            hold1    = Math.max(hold1,    -i);          // The maximum if we've just buy  1st stock so far. 
        }
        return release2; ///Since release1 is initiated as 0, so release2 will always higher than release1.
    }
}