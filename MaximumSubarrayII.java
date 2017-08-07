public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        // write your code
        int sum = 0;
        int l =nums.size();
        int[] leftMax = new int[l];
        int[] rightMax = new int[l];
        int minsum = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<l;i++){
            sum += nums.get(i);
            max = Math.max(max,sum-minsum);
            minsum = Math.min(sum,minsum);
            leftMax[i] = max;
        }
        sum = 0;
        minsum = 0;
        max = Integer.MIN_VALUE;
        for(int i=l-1;i>=0;i--){
            sum +=nums.get(i);
            max = Math.max(max, sum-minsum);
            minsum = Math.min(sum,minsum);
            rightMax[i] = max;
        }
        int res = Integer.MIN_VALUE;
        for(int i=0;i<l-1;i++){
            int left = leftMax[i];
            int right = rightMax[i+1];
            res = Math.max(res,left+right);
        }
        return res;
    }
}