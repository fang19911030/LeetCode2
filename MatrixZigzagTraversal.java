public class Solution {
    /*
     * @param matrix: An array of integers
     * @return: An array of integers
     */
    public int[] printZMatrix(int[][] matrix) {
        // write your code here
        int r = matrix.length;
        int c = matrix[0].length;
        int[] res = new int[r*c];
        int[]up = {0,0};
        int[]bottom = {0,0};
        boolean bottomToUp = true;
        int[] cur = {0};
        while(up[0] !=r-1 || up[1] != c-1){
            updateRes(res,up,bottom,bottomToUp,cur, matrix);
            bottomToUp = bottomToUp==true? false:true;
            if(up[1]!= c-1){
                up[1]++;
            }else{
                up[0]++;
            }
            if(bottom[0]!=r-1){
                bottom[0]++;
            }else{
                bottom[1]++;
            }
        }
        res[cur[0]] = matrix[r-1][c-1];
        return res;
    }
    
    private void updateRes(int[] arr, int[] up, int[] bottom, 
                           boolean flag, int[] cur, int[][] matrix){
        if(flag){
            int[] start = {bottom[0], bottom[1]};
            int[] end = {up[0],up[1]};
            while(start[0]>=end[0]){
                arr[cur[0]++] = matrix[start[0]--][start[1]++]; 
            }
        }else{
            int[] start = {up[0],up[1]};
            int[] end = {bottom[0], bottom[1]};
            while(start[0]<=end[0]){
                arr[cur[0]++] = matrix[start[0]++][start[1]--]; 
            }
        }
    }
};