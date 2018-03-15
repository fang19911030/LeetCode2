class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        if(nums == null || nums.length == 0){
            if(lower == upper){
                res.add(String.valueOf(lower));
            }else{
                String s = String.valueOf(lower)+"->"+String.valueOf(upper);
                res.add(s);
            }
            return res;
        }
        
        int idx = 0;
        int left = lower, right = lower;
        for(int i =lower;i<=upper; i++){
            if(idx < nums.length && i == nums[idx]){
                if(left !=nums[idx]){
                    if(left == right){
                        res.add(String.valueOf(left));
                    }else{
                        String s = String.valueOf(left)+"->"+String.valueOf(right);
                        res.add(s);
                    }
                }
                left = nums[idx]+1;
                idx++;
            }else{
                right = i;
                if(idx == nums.length){
                    right = upper;
                    break;
                }
            }
        }
        if(left<=upper){
            if(left == right){
                res.add(String.valueOf(left));
            }else{
                String s = String.valueOf(left)+"->"+String.valueOf(right);
                res.add(s);
            }
        }
        return res;
    }
}


class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        for(int num: nums){
            if(num == Integer.MIN_VALUE){
                lower = num + 1;
                continue;
            }
            if(lower<num-1) res.add(lower +"->" +(num-1));
            else if(lower == num - 1) res.add(lower+"");
            
            lower = num + 1;
        }
        if(lower == Integer.MIN_VALUE) return res;        //SLOVE Integer overflow
        if(lower == upper) res.add(lower+"");
        else if(lower < upper)res.add(lower+"->"+upper);
        return res;
    }
}
