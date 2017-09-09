class Solution {
    public int[] singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(!set.add(nums[i])){
                set.remove(nums[i]);
            }
        }
        
        int[] res = new int[2];
        int i=0;
        for(Integer t:set){
            res[i++] = t;
        }
        return res;
    }
}