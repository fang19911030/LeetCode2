public class Solution {
    /**
     * @param nums: an array of integers
     * @return: nothing
     */
    public void partitionArray(int[] nums) {
        // write your code here;
        int odd = -1;
        //int even = nums.length;
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2 == 1){
                odd++;
                swap(nums,i,odd);
            }
        }
    }
    
    private void swap(int[] arr, int i, int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}