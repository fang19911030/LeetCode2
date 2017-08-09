class Solution {
    /**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        // write your code here
        int[] merge = new int[A.length+B.length];
        int t1 = 0, t2 = 0;
        for(int i=0;i<merge.length;i++){
            if(t1<A.length && t2<B.length){
                if(A[t1]<=B[t2]){
                    merge[i] = A[t1++];
                }else{
                    merge[i] = B[t2++];
                }   
            }else if(t1<A.length){
                merge[i] = A[t1++];
            }else{
                merge[i] = B[t2++];
            }
        }
        double res = 0;
        if(merge.length%2 == 1){
            res = merge[merge.length/2];
        }else{
            int mid = (merge.length-1)/2;
            res = (merge[mid] +merge[mid+1])/2.0;
        }
        return res;
    }
}