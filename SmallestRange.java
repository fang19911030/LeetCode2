class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int[] res = new int[2];
        if(nums == null){
            return res;
        }
        
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a,b)->a.get(0)-b.get(0));
        int curMax = Integer.MIN_VALUE;
        
        for (List<Integer> list : nums){
            if(!list.isEmpty()){
                pq.offer(list);
                curMax = Math.max(curMax, list.get(0));
            }
        }
        
        if(pq.size() != nums.size()){
            return res;
        }
        res[0] = pq.peek().get(0);
        res[1] = curMax;
        while (pq.size() == nums.size()){
            int[] curRange = new int[] {pq.peek().get(0), curMax};
            System.out.println(Arrays.toString(curRange));
            List<Integer> update = pq.poll();
            update.remove(0);
            if(!update.isEmpty()){
                if(curMax < update.get(0))
                    curMax = update.get(0);
                pq.offer(update);
            }
            if(isSmaller(curRange, res)){
                res[0] = curRange[0];
                res[1] = curRange[1];
            }
        
        }
        return res;
    }
    
    private boolean isSmaller(int[] curRange, int[] res){
        int diff1 = curRange[1] - curRange[0];
        int diff2 = res[1] -res[0];
        
        if(diff1 < diff2){
            return true;
        }else if(diff1 == diff2){
            return curRange[0] < res[0];
        }
        return false;
    }
}