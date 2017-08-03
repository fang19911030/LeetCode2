public class Solution {
    /*
     * @param : An array of Integer
     * @return: an integer
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        if(A== null){
            return 0;
        }
        if(A.length <=1 ){
            return A.length;
        }
        int[] temp1 = new int[A.length];
        int[] temp2 = new int[A.length];
        temp1[0] = 1;
        int res = 0;
        for(int i=1;i<A.length;i++){
            if(A[i]<A[i-1]){
                temp1[i] = temp1[i-1]+1;
            }else{
                temp1[i] = 1;
            }
            res = Math.max(temp1[i],res);
        }
        temp2[0] = 1;
        for(int i=1;i<A.length;i++){
            if(A[i]>A[i-1]){
                temp2[i] = temp2[i-1]+1;
            }else{
                temp2[i] = 1;
            }
            res = Math.max(temp2[i],res);
        }
        return res;
    }
};