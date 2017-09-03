public class Solution {
    /*
     * @param nums: A list of non negative integers
     * @return: A string
     */
    public String largestNumber(int[] nums) {
        // write your code here
        Comparator<Integer> cmp = new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b){
                String strA = a.toString();
                String strB = b.toString();
                return (strB+strA).compareTo(strA+strB);
            }
        };
        Integer[] num = new Integer[nums.length];
        for(int i=0;i<nums.length;i++){
            num[i] = nums[i];
        }
        Arrays.sort(num,cmp);
        if(num[0] == 0){                      // here is the corner case 
            return "0";
        }
        String res = "";
        for(int i=0;i<nums.length;i++){
            res += String.valueOf(num[i]);
        }
        return res;
    }
}