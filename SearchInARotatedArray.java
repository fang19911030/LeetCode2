public class Solution {
    /** 
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */
    public int search(int[] A, int target) {
        // write your code here
        if(A == null || A.length == 0){
            return -1;
        }
        int l1 = 0;
        int r1 = 0;
        int l2 = 0;
        int r2 = A.length-1;
        for(int i=0;i<A.length-1;i++){
            if(A[i]>A[i+1]){
                r1 = i;
                l2 = i+1;
            }
        }
        
        int res1 = -1;
        int res2 = -1;
        while(l1<=r1){
            int mid = l1 +(r1-l1)/2;
            if(A[mid] == target){
                res1 = mid;
                return res1;
            }else if(target>A[mid]){
                l1 = mid+1;
            }else{
                r1 = mid-1;
            }
        }
        while(l2<=r2){
            int mid = l2+(r2-l2)/2;
            if(target == A[mid]){
                return mid;
            }else if(target>A[mid]){
                l2 = mid+1;
            }else{
                r2 = mid-1;
            }
        }
        return -1;
        
    }
    
}
