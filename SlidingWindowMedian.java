public class Solution {
    /*
     * @param : A list of integers
     * @param : An integer
     * @return: The median of the element inside the window at each moving
     */
    public List<Integer> medianSlidingWindow(int[] nums, int k) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        if(nums == null || nums.length==0){
            return res;
        }
        
        for(int i=0;i+k-1<nums.length;i++){
            int j = i+k-1;
            int median = findMedian(nums,i,j);
            res.add(median);
        }
        return res;
        
    }
    
    private int findMedian(int[] arr, int i, int j){
        int[] copy = Arrays.copyOfRange(arr,i,j+1);
        Arrays.sort(copy);
        int length = copy.length;
        if(length%2==1){
            return copy[length/2];
        }else{
            return copy[length/2-1];
        }
    }
};