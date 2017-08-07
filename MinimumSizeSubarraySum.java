public class Solution {
    /**
     * @param nums: an array of integers
     * @param s: an integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
        // write your code here
        if(nums== null || nums.length==0){
            return -1;
        }
        int[][] sums = new int[nums.length][nums.length];
        for(int i=0;i<nums.length;i++){
            sums[i][i] = nums[i];
        }
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                sums[i][j] = sums[i][j-1]+nums[j];
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                if(sums[i][j]>=s){
                    res = Math.min(res,j-i+1);
                }
            }
        }
        return res = res==Integer.MAX_VALUE? -1:res;
    }
    /**
     * @param nums: an array of integers
     * @param s: an integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
        // write your code here
        
        if(nums==null || nums.length==0){
            return -1;
        }
        
        int i=0;
        int j=0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        while(i<nums.length){
            sum+=nums[i];
            while(sum>=s){
                res = Math.min(i-j+1,res);
                sum -=nums[j++];
            }
            i++;
        }
        return res = res== Integer.MAX_VALUE? -1:res;
    }
}