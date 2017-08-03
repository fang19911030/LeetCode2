public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        return getSum(nums,0,nums.length-1);
    }
    
    private int getSum(int[] arr, int left, int right){
        if(left<right){
            int mid = left+(right-left)/2;
            int leftSum = getSum(arr,left,mid);
            int rightSum = getSum(arr,mid+1,right);
            int sum = getMiddle(arr, left, mid, right);
            return Math.max(sum, Math.max(leftSum,rightSum));
        }else{
            return arr[left];
        }
    }
    
    private int getMiddle(int[] arr, int left, int mid, int right){
        int leftSum = Integer.MIN_VALUE;
        int rightSum = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=mid;i>=left;i--){
            sum+=arr[i];
            leftSum = Math.max(leftSum,sum);
        }
        sum = 0;
        for(int i=mid+1;i<=right;i++){
            sum+=arr[i];
            rightSum = Math.max(rightSum,sum);
        }
        return leftSum+rightSum;
    }
}