public class Solution {
    /*
     * @param : a vector of integers
     * @return: an integer
     */
    public int maxArea(int[] heights) {
        // write your code here
        if(heights==null || heights.length<=1){
            return 0;
        }
        int[] right = new int[heights.length];
        int[] left = new int[heights.length];
        for(int i=0;i<heights.length;i++){
            int j=i;
            while(j<heights.length){
                if(heights[j]>=heights[i]){
                    left[i] = j-i;
                }
                j++;
            }

        }
        for(int i=heights.length-1;i>=0;i--){
            int j = i;
            while(j>0){
                if(heights[j]>=heights[i]){
                    right[i] = i-j;
                }
                j--;
                
            }

        }
        int res = 0;
        for(int i=0;i<heights.length;i++){
            int area1 = left[i]*heights[i];
            int area2 = right[i]*heights[i];
            int area = Math.max(area1,area2);
            res = Math.max(res,area);
        }
        return res;
    }
};