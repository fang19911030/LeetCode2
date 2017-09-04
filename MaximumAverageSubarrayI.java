class Solution {
    public double findMaxAverage(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return 0.0;
        }

        double res = Double.NEGATIVE_INFINITY;
        int sum = 0;
        for(int l=0, r=0;r<nums.length;r++){
            sum +=nums[r];
            if(r-l+1>k){
                sum-= nums[l];
                l++;
            }
            if(r-l+1==k){
                res = Math.max(res, sum/(k*1.0));
            }
        }
        return res;
        
    }
}