public class Solution {
    public int removeDuplicates(int[] nums) {
        // write your code here
        if(nums == null || nums.length==0){
            return 0;
        }
        int t = 0;
        int pre = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i] != pre){
                t++;
                pre = nums[i];                       //update pre before swap!
                swap(nums,i,t);
            }
        }
        return t+1;
        
    }
    
    private void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
        
    }
}