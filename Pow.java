public class Solution {
    /**
     * @param x the base number
     * @param n the power number
     * @return the result
     */
    public double myPow(double x, int n) {
        // Write your code here
        if(x == 0.0){
            return 0;
        }
        if( n == 0){
            return 1.0;
        }
        if( n == 1){
            return x;
        }
        if(n < 0){
            x = 1/x;
            n *= -1;
        }
        if (n%2 == 0){
            return myPow(x,n/2)*myPow(x,n/2);
        }else{
            return x * myPow(x, n-1);
        }
    }
}