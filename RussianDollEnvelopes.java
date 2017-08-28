class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int[][] e= envelopes;
        if(e == null || e.length==0 ||e[0] == null || e[0].length == 0){
            return 0;
        }
        
        Comparator<int[]> cmp = new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[]b){
                if(a[0] == b[0]){
                    return b[1]-a[1];
                }else{
                    return a[0]-b[0];
                }
            }
        };
        
        Arrays.sort(e,cmp);
        int len =0;
        int[] dp = new int[envelopes.length];
        for(int[] t:e){
            int index = Arrays.binarySearch(dp,0,len,t[1]);
            if(index<0){
                index = -(index+1);
            }
            dp[index] = t[1];
            if(index == len){
                len++;
            }
        }
        return len;
    }

    public int maxEnvelopes(int[][] envelopes) {
        if (   envelopes           == null
            || envelopes.length    == 0
            || envelopes[0]        == null
            || envelopes[0].length == 0){
            return 0;    
        }
        
        Arrays.sort(envelopes, new Comparator<int[]>(){
            @Override
            public int compare(int[] e1, int[] e2){
                return Integer.compare(e1[0], e2[0]);
            }
        });
        
        int   n  = envelopes.length;
        int[] dp = new int[n];
        
        int ret = 0;
        for (int i = 0; i < n; i++){
            dp[i] = 1;
            
            for (int j = 0; j < i; j++){
                if (   envelopes[i][0] > envelopes[j][0]
                    && envelopes[i][1] > envelopes[j][1]){
                    dp[i] = Math.max(dp[i], 1 + dp[j]);    
                }
            }
            
            ret = Math.max(ret, dp[i]);
        }
        return ret;
    }
}