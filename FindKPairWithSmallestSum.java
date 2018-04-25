class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<>();
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return res;
        
        PriorityQueue<int[]> maxQueue = new PriorityQueue<int[]>(k, (a,b)-> b[0]+b[1] - a[0]-a[1]);
        
        for(int i=0; i < nums1.length; i++){
            for(int j=0; j<nums2.length; j++){
                int sum = nums1[i] + nums2[j];
                if(maxQueue.size() == k){
                    int[] peek = maxQueue.peek();
                    int curMax = peek[0] + peek[1];
                    if(sum > curMax){
                        break;
                    }else if(sum < curMax){
                        int[] pair = {nums1[i], nums2[j]};
                        maxQueue.poll();
                        maxQueue.offer(pair);
                    }
                }else{
                    int[] pair = {nums1[i], nums2[j]};
                    maxQueue.offer(pair);
                }
            }
        }
        
        while(!maxQueue.isEmpty()){
            res.add(0, maxQueue.poll());
        }
        return res;
    }
}

public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();
        int m = nums1.length, n = nums2.length;
        List<int[]> res = new ArrayList<int[]>();
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0 || k <= 0) return res;
        for(int j = 0; j <= n-1; j++) pq.offer(new Tuple(0, j, nums1[0]+nums2[j]));
        for(int i = 0; i < Math.min(k, m *n); i++) {
            Tuple t = pq.poll();
            res.add(new int[]{nums1[t.x], nums2[t.y]});
            if(t.x == m - 1) continue;
            pq.offer(new Tuple (t.x + 1, t.y, nums1[t.x + 1] + nums2[t.y]));
        }
        return res;
    }
}

class Tuple implements Comparable<Tuple> {
    int x, y, val;
    public Tuple (int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
    
    @Override
    public int compareTo (Tuple that) {
        return this.val - that.val;
    }
}