public class Solution {
	/** 
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
	    //write your code here
	    int l=-1;
	    for(int i=0;i<nums.length;i++){
	        if(nums[i]<k){
	            l++;
	            swap(nums,i,l);
	        }
	    }
	    return l+1;
    }
    
    private void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}