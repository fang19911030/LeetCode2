/*How to handler some special input is the key point of this question   */

class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        if(nums == null || nums.length == 0){
            String range = getRange(lower, upper);
            res.add(range);
            return res;
        }
        if(nums[0]!=lower && nums[0]>=lower+1){
            String range = getRange(lower,nums[0]-1);
            res.add(range);
        }
        
        for(int i=0;i<nums.length-1;i++){
            int pre = nums[i];
            int next = nums[i+1];
            if( next!=pre && next!= pre +1){
                int left = pre+1;
                int right = next-1;
                if (left >= lower  && right <= upper){
                    if (left == right){
                        res.add(String.valueOf(left));
                    }else{
                        String range = String.valueOf(left)+"->"+String.valueOf(right);
                        res.add(range);
                    }
                }
            }
        }
        if(nums[nums.length-1] != upper && nums[nums.length-1]+1<=upper){
            String range = getRange(nums[nums.length-1]+1,upper);
            res.add(range);
        }
        return res;
    }
    
    private String getRange(int left, int right){
        if(left == right){
            return String.valueOf(left);
        }else{
            return String.valueOf(left)+"->"+String.valueOf(right);
        }
    }
}