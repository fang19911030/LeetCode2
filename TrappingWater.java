public class Solution {
    /*
     * @param : a list of integers
     * @return: a integer
     */
    public int trapRainWater(int[] heights) {
        // write your code here
        if(heights == null || heights.length<=1){
            return 0;
        }
        int size = heights.length;
        int[] leftMax = new int[size];
        int[] rightMax = new int[size];
        leftMax[0] = -1;
        rightMax[size-1] = -1;
        for(int i=1;i<size;i++){
            if(i != 1){
                leftMax[i] = Math.max(leftMax[i-1],heights[i]);
            }else{
                leftMax[1] = Math.max(heights[1], heights[0]);
            }
        }
        for(int i=size-2;i>=0;i--){
            if(i != size-2){
                rightMax[i] = Math.max(rightMax[i+1],heights[i]);
            }else{
                rightMax[i] = Math.max(heights[size-1], heights[size-2]);
            }
        }
        int res = 0;
        for(int i=0;i<heights.length;i++){
            if(leftMax[i]== -1 || rightMax[i] == -1){
                continue;
            }else{
                int min = Math.min(leftMax[i], rightMax[i]);
                res += min-heights[i];
            }
        }
        return res;
    }
};