public class Solution {
    /**
     * @param A, B: Two integer arrays.
     * @return: Their smallest difference.
     */
    public int smallestDifference(int[] A, int[] B) {
        // write your code here
        Arrays.sort(A);
        Arrays.sort(B);
        int t1 = 0;
        int t2 = 0;
        int res = Integer.MAX_VALUE;
        while (t1<A.length && t2<B.length){
            while(t1<A.length && t2 <B.length && A[t1]<=B[t2]){
                res = Math.min(B[t2]-A[t1], res);
                t1++;
            }
            while(t1<A.length && t2 <B.length && B[t2]<A[t1]){
                res = Math.min(A[t1]-B[t2],res);
                t2++;
            }
        }
        return res;
    }
}
