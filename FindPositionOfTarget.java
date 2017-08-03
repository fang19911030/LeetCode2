class Solution {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        //write your code here
        if(nums == null || nums.length == 0){
            return -1;
        }
        int l = 0;
        int r = nums.length-1;
        int mid = 0;
        while(l<=r){
            mid = l+(r-l)/2;
            if(target == nums[mid]){
                break;
            }else if(target>nums[mid]){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        
        if(nums[mid] != target){
            return -1;
        }else{
            while(mid>=1 && nums[mid] == nums[mid-1]){
                mid--;
            }
            return mid;
        }
    }
}