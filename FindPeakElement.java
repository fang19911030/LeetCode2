class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        // write your code here
        if(A == null || A.length <=1){
            return 0;
        }
        for(int i=1;i<A.length-1;i++){
            if(A[i-1]<A[i] && A[i]>A[i+1]){
                return i;
            }
        }
        return 0;
    }
}