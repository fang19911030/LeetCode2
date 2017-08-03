public class Solution {
    /**
     * @param nums an integer array
     * @return nothing, do this in-place
     */
    public void moveZeroes(int[] nums) {
        // Write your code here
        if(nums == null || nums.length == 0){
            return;
        }
        int r = nums.length;
        for(int i=1;i<nums.length;i++){
            for(int j=i;j>=1;j--){
                if(nums[j-1] == 0 && nums[j]!= 0){
                    swap(nums,j-1,j);
                }
            }
        }
    }
    
    private void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}