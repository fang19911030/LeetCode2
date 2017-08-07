/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class Solution {
    /**
     * @param intervals: An interval array
     * @return: Count of airplanes are in the sky.
     */
    public int countOfAirplanes(List<Interval> airplanes) { 
        // write your code here
        if(airplanes == null){
            return 0;
        }
        int res = 0;
        Map<Integer,Integer> map  = new HashMap<>();
        for(Interval i:airplanes){
            int start = i.start;
            int end = i.end;
            for(int j=start;j<end;j++){
                if(map.containsKey(j)){
                    res = Math.max(res,map.get(j)+1);
                    map.put(j,map.get(j)+1);
                }else{
                    map.put(j,1);
                    res = Math.max(res,1);
                }
            }
        }
        return res;
    }
}