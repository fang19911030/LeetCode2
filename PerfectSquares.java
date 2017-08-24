public class Solution {
    /*
     * @param n: a positive integer
     * @return: An integer
     */
     
    public int numSquares(int n) {
        // write your code here
        return help(1,n,0);       
    }
    
    private int help(int start, int left, int nums){
        if(left == 0){
            return nums;
        }
        int res = Integer.MAX_VALUE;
        for(int i=start;i*i<=left;i++){
            res = Math.min(res,help(start,left-i*i,nums+1));
        }
        return res;
    }

    public int numSquares2(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i=1;i<=n;++i){
            int min = Integer.MAX_VALUE;
            int j = 1;
            while(i-j*j>=0){
                min = Math.min(min,dp[i-j*j]+1);
                ++j;
            }
            dp[i] = min;
        }
        return dp[n];
            
    }

    public int numSquares3(int n) {
        // write your code here
        int res = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(n);
        while(!queue.isEmpty()){
            Queue<Integer> next = new ArrayDeque<>();
            while(!queue.isEmpty()) {
                int cur = queue.poll();
                for (int j = 1; j * j <= cur; j++) {
                    if (cur - j * j == 0) {
                        return ++res;
                    } else {
                        next.offer(cur - j * j);
                    }
                }
            }
            queue = next;
            res++;

        }
        return res;
    }
}