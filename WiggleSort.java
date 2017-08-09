public class Solution {
    /**
     * @param nums a list of integer
     * @return void
     */
    public void wiggleSort(int[] nums) {
        // Write your code here
        if(nums == null || nums.length<=1){
            return;
        }
        
        for(int i=1;i<nums.length;i++){
            if(i%2==0){
                if(nums[i]>nums[i-1]){
                    swap(nums,i,i-1);
                }
            }else{
                if(nums[i]<nums[i-1]){
                    swap(nums,i,i-1);
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