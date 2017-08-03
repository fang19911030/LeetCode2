public class Solution {
    /*
     * @param nums: An integer
     * @return: 
     */
    
    public void recoverRotatedSortedArray(List<Integer> nums) {
        // write your code here
        for(int i=0;i<nums.size()-1;i++){
            if(nums.get(i)>nums.get(i+1)){
                int t = nums.size()-i-1;
                Collections.rotate(nums,t);
                return;
            }
        }
    }
    
};