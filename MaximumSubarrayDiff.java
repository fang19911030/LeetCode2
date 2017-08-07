public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer indicate the value of maximum difference between two
     *          Subarrays
     */
    public int maxDiffSubArrays(int[] nums) {
        // write your code here
        if(nums== null || nums.length==0){
            return 0;
        }
        if(nums.length == 1){
            return Math.abs(nums[0]);
        }
        int[][] sums = new int[nums.length][nums.length];
        for(int i=0;i<nums.length;i++){
            sums[i][i] = nums[i];
        }
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                sums[i][j] = sums[i][j-1]+nums[j];
            }
        }
        int res = 0;
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                int sumA = sums[i][j];
                for(int t = j+1;t<nums.length;t++){
                    for(int x = t;x<nums.length;x++){
                        int sumB = sums[t][x];
                        res = Math.max(res,Math.abs(sumA-sumB));
                    }
                }
            }
        }
        return res;

    }
    /**
     * @param nums: A list of integers
     * @return: An integer indicate the value of maximum difference between two
     *          Subarrays
     */
    public int maxDiffSubArrays(int[] nums) {
        // write your code here
        if(nums==null || nums.length<=1){
            return 0;
        }
        int l = nums.length;
        int[] leftMax = new int[l];
        int[] leftMin = new int[l];
        int[] rightMax = new int[l];
        int[] rightMin = new int[l];
        int sum = 0;
        int minsum = 0;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for(int i=0;i<l;i++){
            sum += nums[i];
            max = Math.max(max,sum-minsum);
            leftMax[i] = max;
            minsum = Math.min(minsum,sum);
        }
        sum = 0;
        minsum = 0;
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        for(int i=l-1;i>=0;i--){
            sum+=nums[i];
            max = Math.max(max,sum-minsum);
            rightMax[i] = max;
            minsum = Math.min(minsum,sum);
        }
        sum = 0;
        int maxsum = 0;
        for(int i=0;i<l;i++){
            sum+=nums[i];
            min = Math.min(min,sum-maxsum);
            maxsum = Math.max(sum,maxsum);
            leftMin[i] = min;
        }
        sum = 0;
        maxsum = 0;
        min = Integer.MAX_VALUE;
        for(int i=l-1;i>=0;i--){
            sum+=nums[i];
            min=Math.min(min,sum-maxsum);
            maxsum = Math.max(sum,maxsum);
            rightMin[i] = min;
        }
        
        int res = 0;
        for(int i=0;i<nums.length-1;i++){
            int diffa = leftMax[i]-rightMin[i+1];
            int diffb = leftMin[i]-rightMax[i+1];
            int cur = Math.max(Math.abs(diffa),Math.abs(diffb));
            res = Math.max(cur,res);
        }
        return res;
    }

}