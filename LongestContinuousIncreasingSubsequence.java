class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int l = 0 ;
        int r = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        while(r<nums.length){
            if(stack.isEmpty()){
                stack.push(nums[r]);
            }else{
                if(nums[r]> stack.peek()){
                    stack.push(nums[r]);
                }else{
                    res = Math.max(res, stack.size());
                    stack = new ArrayDeque<>();
                    stack.push(nums[r]);
                }
            }
            r++;
        }
        res = Math.max(res, stack.size());
        return res;
    }
    public int findLengthOfLCIS(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return 1;
        }
        
        int l = 0;
        int r = 0;
        int res = 1;
        while(r<nums.length){
            if(r-1 >=0 && nums[r]<= nums[r-1]){
                res = Math.max(res, r-l);
                l = r;
            }
            r++;
        }
        res = Math.max(res,r-l);
        return res;
    }

}