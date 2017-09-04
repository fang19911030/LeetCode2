public class Solution {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        // write your code here
        return findMin(nums,0, nums.length - 1);
    }
    
    private int findMin(int[]nums, int low, int high){
        if (low > high) return nums[0];
        
        if(low == high) return nums[low];
        
        int mid = low + ((high - low)>>1);
        if (mid < high && nums[mid+1] < nums[mid])
            return nums[mid+1];
 
        // Check if mid itself is minimum element
        if (mid > low && nums[mid] < nums[mid - 1])
            return nums[mid];
        if(nums[high]> nums[mid]){
            return findMin(nums, low, mid-1);
        }
        return findMin(nums, mid+1, high);
    }
}