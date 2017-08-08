public class Solution {
    /** 
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        // write your code here
        if(A == null || A.length==0){
            int[] res = {-1,-1};
            return res;
        }
        int l = 0;
        int r = A.length-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(A[mid] == target){
                int[] res = new int[2];
                int j = mid;
                while(j>=l){
                    if(A[j] == A[mid]){
                        res[0] = j;
                    }else{
                        break;
                    }
                    j--;
                }
                j = mid;
                while( j<=r){
                    if(A[j] == A[mid]){
                        res[1] = j;
                    }else{
                        break;
                    }
                    j++;
                }
                return res;
            }else if(A[mid]<target){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        int[] res = {-1,-1};
        return res;
    }
}