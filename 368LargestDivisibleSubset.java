class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        if(nums.length == 1){
            res.add(nums[0]);
            return res;
        }
        List<Integer>[] record = new List[nums.length];
        for(int i=0; i< record.length; i++){
            record[i] = new ArrayList<>();
        }
        
        
        
        Arrays.sort(nums);
        record[0].add(nums[0]);
        
        for(int i=1; i<nums.length; i++){
            for(int j=i-1; j>=0; j--){
                if(nums[i] % nums[j] == 0){
                    if(record[i].size() < record[j].size() + 1){
                        record[i] = new ArrayList<>();
                        record[i].addAll(record[j]);
                        record[i].add(nums[i]);
                    }
                }
            
            }
            if(record[i].size() == 0) record[i].add(nums[i]);
            res = res.size() > record[i].size()? res : record[i];
        }
        return res;
        
        
    }
}

public static List<Integer> largestDivisibleSubset(int[] nums) {
    List<Integer> res = new ArrayList<Integer>();
    if (nums == null || nums.length == 0) return res;
    Arrays.sort(nums);
    int[] dp = new int[nums.length];
    dp[0] = 1;

    //for each element in nums, find the length of largest subset it has.
    for (int i = 1; i < nums.length; i++){
        for (int j = i-1; j >= 0; j--){
            if (nums[i] % nums[j] == 0){
                dp[i] = Math.max(dp[i],dp[j] + 1);
            }
        }
    }

    //pick the index of the largest element in dp.
    int maxIndex = 0;
    for (int i = 1; i < nums.length; i++){
        maxIndex = dp[i] > dp[maxIndex] ?  i :  maxIndex;
    }

    //from nums[maxIndex] to 0, add every element belongs to the largest subset.
    int temp = nums[maxIndex];
    int curDp = dp[maxIndex];
    for (int i = maxIndex; i >= 0; i--){
        if (temp % nums[i] == 0 && dp[i] == curDp){
            res.add(nums[i]);
            temp = nums[i];
            curDp--;
        }
    }
    return res;
}



public class Solution {                                                // this method need more consideration.
    TreeSet<Long> mem = new TreeSet<Long>();
    long max = 0;
    List<Integer> ret = new ArrayList();
    Map<Long, List<Integer> > visited = new HashMap<>();
   
    public List<Integer> helper(long cur) {
        if (cur > max || ! mem.contains(cur) ) return null;
        if (visited.containsKey(cur)) return visited.get(cur);
        List<Integer> list = new ArrayList<>();
        long i=2; // the factor for the next multiple of current value
        while ( mem.ceiling(cur*i) != null ) { // no more multiple
            // use O(log N) to find next multiple
            long next = mem.ceiling(cur*i);
            if ( next % cur == 0 ) {
                List<Integer> temp = helper(next);
                if (temp != null  && temp.size() > list.size() )
                    list = new ArrayList(temp);
            }
            i=(next/cur)+1; // increase the factor based on the gap. 
        }
        list.add((int)cur);
        visited.put(cur, list);
        return list;
    }
    
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums==null || nums.length ==0) return ret;
        int len = nums.length;
        if (len == 1) { 
            ret.add(nums[0]);
            return ret;
        }
        for (int num : nums) {
            mem.add((long)num);
        }
        max = mem.last();
        for (int num : nums) { 
            List<Integer> temp = helper((long)num);
            if (temp != null  && temp.size() > ret.size() )
                ret = new ArrayList(temp);
        }
        return ret;
    }
}