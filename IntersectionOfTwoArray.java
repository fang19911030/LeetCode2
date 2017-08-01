public class Solution {
    /**
     * @param nums1 an integer array
     * @param nums2 an integer array
     * @return an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        // Write your code here
        if(nums1 == null || nums2 == null){
            return new int[0];
        }
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> temp = new HashSet<Integer>();
        for(int i=0;i<nums1.length ; i++){
            set.add(nums1[i]);
        }

        for(int i=0;i<nums2.length;i++){
            if(set.contains(nums2[i])){
                temp.add(nums2[i]);
            }
        }
        int[] res = new int[temp.size()];
        List<Integer> list = new ArrayList<>(temp);
        for(int i=0;i<res.length;i++){
            res[i] = list.get(i);
        }
        return res;
    }
}