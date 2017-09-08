class Solution {
    public boolean isReflected(int[][] points) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        Set<String> set = new HashSet<>();
        for(int i=0;i<points.length;i++){
            max = Math.max(max,points[i][0]);
            min = Math.min(min,points[i][0]);
            String key = String.valueOf(points[i][0])+","+String.valueOf(points[i][1]);
            set.add(key);
        }
        int sum = max+min;
        for(int i=0;i<points.length;i++){
            int crospX = sum-points[i][0];
            String key = String.valueOf(crospX)+","+String.valueOf(points[i][1]);
            if(!set.contains(key)){
                return false;
            }
        }
        return true;
    }
}