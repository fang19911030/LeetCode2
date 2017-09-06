public class Solution {
    /*
     * @param dividend: the dividend
     * @param divisor: the divisor
     * @return: the result
     */
    public int divide(int dividend, int divisor) {
        // write your code here
        if(divisor == 0){
            return 2147483647;
        }
        if( dividend > 0 && divisor > 0){
            return help((long)dividend, (long)divisor);
        }else if(dividend < 0 && divisor < 0){
            return help(Math.abs((long)dividend), Math.abs((long)divisor));
        }else{
            return (-1) * help(Math.abs((long)dividend),Math.abs((long)divisor));
        }
    }
    
    private int help(long dividend, long divisor){
        int res = 0;
        
        while(dividend >=divisor){
            dividend -= divisor;
            res++;
            if(res == Integer.MAX_VALUE){
                return res;
            }
            
        }
        return res;
    }

    public int divide(int divident, int divisor){
        int sign = 1;
        if((divident > 0 && divisor < 0) || (divident < 0 && divisor > 0)){
            sign = -1;
        }

        long ldivident = Math.abs((long)divident);
        long ldivisor = Math.abs((long)divisor);

        if( ldivisor == 0){
            return Integer.MAX_VALUE;
        }

        long ans = ldivide(ldivident,ldivisor);
        if( ans > Integer.MAX_VALUE){
            return sign==1? Integer.MAX_VALUE:Integer.MIN_VALUE;
        }else{
            return (int)(sign*ans);
        }

    }

    private long ldivide(long ldivident, long ldivisor){
        if(ldivident<ldivisor){
            return 0;
        }
        long sum = ldivisor;
        long res =1;
        while((sum+sum)<=ldivident){
            sum += sum;
            res +=res;
        }
        return res+ldivide(ldivident-sum,ldivisor);
    }
}