class Solution {
    public int minPatches(int[] nums, int n) {
        if ( n == 0){
            return 0;
        }
        int res = 0;
        List<Integer> num = new ArrayList<>();
        if(nums == null || nums.length == 0){
            num.add(1);
            res++;
        }else{
            for (Integer t:nums){
                num.add(t);
            }
        }
        
        Set<Integer> sums = new HashSet<>();

        while(sums.size()<n){
            for(int i=1; i<= num.size();i++){
                for(int j=0; j<=num.size() -i;j++){
                    getSum(num,i,sums,j,0);
                }
            }
            System.out.println(sums);
            for(int i = 1;i<=n;i++){
                if(!sums.contains(i)){
                    num.add(i);
                    res++;
                    break;
                }
            }
            System.out.println(num);
        }
        return res;
    }
    
    private void getSum(List<Integer> num, int k, Set<Integer> set, int idx, int sum){
        if(k==0){
            set.add(sum);
            return;
        }
        if(idx >=num.size()){
            return;
        }
        sum += num.get(idx);
        for(int i = idx+1; i <= num.size();i++){
            getSum(num, k-1,set,i,sum);
        }
        sum -=num.get(idx);        
    }
}