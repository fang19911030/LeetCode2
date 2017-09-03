class Solution {
    public int reversePairs(int[] nums) {
        return reversePairsSub(nums, 0, nums.length - 1);
    }

    private int reversePairsSub(int[] nums, int l, int r) {
        if (l >= r) return 0;

        int m = l + ((r - l) >> 1);
        int res = reversePairsSub(nums, l, m) + reversePairsSub(nums, m + 1, r);

        int i = l, j = m + 1, k = 0, p = m + 1;
        int[] merge = new int[r - l + 1];

        while (i <= m) {
            while (p <= r && nums[i] > 2L * nums[p]) p++;
            res += p - (m + 1);

            while (j <= r && nums[i] >= nums[j]) merge[k++] = nums[j++];
            merge[k++] = nums[i++];
        }

        while (j <= r) merge[k++] = nums[j++];

        System.arraycopy(merge, 0, nums, l, merge.length);

        return res;
    }
    public int reversePairs2(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(nums[nums.length-1],1);
        int res = 0;
        for(int i=nums.length-2;i>=0;i--){
            int cur = nums[i];
            if(cur % 2 == 0){
                Map<Integer, Integer> less = map.headMap(cur/2);
                for(Integer key: less.keySet()){
                    res += less.get(key);
                }
            }else{
                Map<Integer, Integer> less = map.headMap(cur/2);
                for(Integer key: less.keySet()){
                    res += less.get(key);
                }
                res += map.getOrDefault(cur/2,0);
            }
            if(map.containsKey(cur)){
                map.put(cur,map.get(cur)+1);
            }else{
                map.put(cur,1);
            }
            
        }
        return res;
    }
}