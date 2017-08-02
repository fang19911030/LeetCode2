public class Solution {
    /*
     * @param nums an array of Integer
     * @param target = nums[index1] + nums[index2]
     * @return [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] nums, int target) {
        // write your code here
        int[] res = new int[2];
        for(int i=0;i<nums.length-1 && nums[i]<=target/2;){
            int right = binarySearch(nums,i+1,nums.length-1,target-nums[i]);
            if(right != -1){
                res[0] = i+1;
                res[1] = right+1;
                return res;
            }
            while(i<nums.length-1 && nums[i] == nums[i+1]){
                i++;
            }
            i++;
        }
        return res;
        
    }
    
    private int binarySearch(int[] arr, int left, int right, int k){
        int l = left;
        int r = right;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(arr[mid] == k){
                return mid;
            }
            if(arr[mid]<k){
                l = mid+1;
            }
            if(arr[mid]>k){
                r = mid-1;
            }
        }
        return -1;
    }
}