public class Solution {
    /**
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
    public int minSubArray(ArrayList<Integer> nums) {
        return getSmall(nums,0,nums.size()-1);
    }
    
    private int getSmall(ArrayList<Integer>nums, int left, int right){
        if(left<right){
            int mid = left+(right-left)/2;
            int leftSum = getSmall(nums, left,mid);
            int rightSum = getSmall(nums,mid+1,right);
            int midSum = getMid(nums, left,mid,right);
            return Math.min(midSum, Math.min(leftSum, rightSum));
        }else{
            return nums.get(left);
        }
    }
    
    private int getMid(ArrayList<Integer>nums, int left, int mid, int right){
        int leftSum = Integer.MAX_VALUE;
        int rightSum = Integer.MAX_VALUE;
        int cur = 0;
        for(int i=mid;i>=left;i--){
            cur += nums.get(i);
            leftSum = Math.min(cur,leftSum);
        }
        cur = 0;
        for(int i = mid+1;i<=right;i++){
            cur += nums.get(i);
            rightSum = Math.min(cur,rightSum);
        }
        cur = leftSum+rightSum;
        return Math.min(cur, Math.min(leftSum, rightSum));
    }
}