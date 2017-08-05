public class Solution {
    /**
     * @param A an integer array
     * @return  A list of integers includes the index of the first number and the index of the last number
     */
    public ArrayList<Integer> continuousSubarraySum(int[] A) {
        // Write your code here
        ArrayList<Integer> res = new ArrayList<>();
        if(A==null || A.length==0){
            return res;
        }
        int[] indexs = help(A,0,A.length-1);
        res.add(indexs[0]);
        res.add(indexs[1]);
        return res;
    }
    
    private int[] help(int[] arr, int left, int right){
        if(left == right){
            int[] res = {left,right,arr[left]};
            return res;
        }else{
            int mid = left+(right-left)/2;
            int[]leftSum =help(arr,left,mid);
            int[]rightSum = help(arr,mid+1,right);
            int[] midSum = getMid(arr,left,mid,right);
            int[] largest;
            if(leftSum[2]>rightSum[2]){
                largest = leftSum;
            }else{
                largest = rightSum;
            }
            if(largest[2]>midSum[2]){
                return largest;
            }else{
                return midSum;
            }
        }
    }
    
    private int[] getMid(int[] arr, int left, int mid, int right){
        int[] res = new int[3];
        int[] l=new int[2];
        l[1] = Integer.MIN_VALUE;
        int[] r = new int[2];
        r[1] = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=mid;i>=left;i--){
            sum +=arr[i];
            if(sum>l[1]){
                l[1] = sum;
                l[0] = i;
            }
        }
        sum = 0;
        for(int i=mid+1;i<=right;i++){
            sum += arr[i];
            if(sum>r[1]){
                r[1] = sum;
                r[0] = i;
            }
        }
        res[0] = l[0];
        res[1] = r[0];
        res[2] = l[1]+r[1];
        return res;
    }
}