/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals == null || intervals.length == 0){
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int res = 1;
        for(Interval i:intervals){
            for(int j=i.start;j<i.end;j++){
                if(!map.containsKey(j)){
                    map.put(j,0);
                }
                map.put(j, map.get(j)+1);
                res = Math.max(res, map.get(j));
            }
        }
        return res;
    }
    public int minMeetingRooms2(Interval[] intervals) {
        if(intervals == null || intervals.length == 0){
            return 0;
        }
        
        Arrays.sort(intervals, (a, b)->a.start-b.start);
        Comparator<Interval> cmp = new Comparator<Interval>(){
            @Override
            public int compare(Interval a, Interval b){
                return a.end- b.end;
            }
        };
        PriorityQueue<Interval> pq = new PriorityQueue<Interval>(intervals.length,cmp);
        pq.offer(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            Interval iter = pq.poll();
            if(intervals[i].start >= iter.end){
                iter.end = intervals[i].end;
            }else{
                pq.offer(intervals[i]);
            }
            pq.offer(iter);
        }
        return pq.size();
    }
}