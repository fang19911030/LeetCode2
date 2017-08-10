public class Solution {
    /**
     * @param points a list of points
     * @param origin a point
     * @param k an integer
     * @return the k closest points
     */
    public Point[] kClosest(Point[] points, Point origin, int k) {
        // Write your code here
        Point[] res = new Point[k];
        if(points == null || points.length == 0){
            return res;
        }
        PointComparator cmp = new PointComparator(origin);
        
        Arrays.sort(points,cmp);
        for(int i=0;i<k;i++){
            res[i] = points[i];
        }
        return res;
    }
}

class PointComparator implements Comparator<Point>{
    
    private Point origin;
    
    public PointComparator(Point origin){
        this.origin = origin;
    }
      public int compare(Point a, Point b){
          Double dista = Math.sqrt(Math.pow(a.x-origin.x,2) +Math.pow(a.y-origin.y,2));
          Double distb = Math.sqrt(Math.pow(b.x-origin.x,2) +Math.pow(b.y-origin.y,2));
          if(dista == distb){
              if(a.x!=b.x){
                  return a.x-b.x;
              }else{
                  return a.y-b.y;
              }
          }else{
              return dista.compareTo(distb);
          }
      }
}