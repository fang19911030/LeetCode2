public class Solution {
    /**
     * @param matrix: a matrix of integers
     * @param k: an integer
     * @return: the kth smallest number in the matrix
     */
    public int kthSmallest(int[][] matrix, int k) {
        // write your code here
        if(matrix==null){
            return 0;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int r = matrix.length;
        int c = matrix[0].length;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                queue.offer(matrix[i][j]);
            }
        }
        
        int res = 0;
        for(int i=0;i<k && !queue.isEmpty();i++){
            res = queue.poll();
        }
        return res;
    }
}