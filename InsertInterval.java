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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        
        if(intervals == null || intervals.size() == 0){
            res.add(newInterval);
            return res;
        }
        
        if(newInterval == null){
            return intervals;
        }
        
        boolean inserted = false;
        for(Interval i:intervals){
            if(i.end<newInterval.start){
                res.add(i);
            }else if(isOverlap(i, newInterval)){
                newInterval.start = Math.min(i.start, newInterval.start);
                newInterval.end = Math.max(i.end, newInterval.end);
            }else{
                if(inserted == false){
                    res.add(newInterval);
                    inserted = true;
                }
                res.add(i);
            }
        }
        if(res.size() == 0 || inserted == false) res.add(newInterval);
        return res;
        
    }

    private boolean isOverlap(Interval cur, Interval p){
        if(cur.end>=p.start && cur.start<p.start){
            return true;
        }
        
        if(cur.end<=p.end && cur.start >=p.start){
            return true;
        }
        
        if(cur.start<=p.end && cur.end > p.end){
            return true;
        }
        return false;
    }
}