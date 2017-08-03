/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class Solution {
    /**
     * @param intervals, a collection of intervals
     * @return: A new sorted interval list.
     */
    public List<Interval> merge(List<Interval> intervals) {
        // write your code here
        Comparator<Interval> cmp = new Comparator<Interval>(){
          @Override
          public int compare(Interval a, Interval b){
            return a.start-b.start;
          }
        };
        Collections.sort(intervals,cmp);
        
        List<Interval> res = new ArrayList<>();
        if(intervals == null || intervals.size() ==0){
            return res;
        }
        res.add(intervals.get(0));
        for(int i=1;i<intervals.size();i++){
            Interval last = res.get(res.size()-1);
            Interval cur = intervals.get(i);
            if(cur.start<=last.end){
                if(last.end >=cur.end){
                    continue;
                }else{
                    last.end = cur.end;
                }
            }else{
                res.add(cur);
            }
        }
        return res;
        
    }

}