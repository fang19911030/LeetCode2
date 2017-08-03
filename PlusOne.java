public class Solution {
    /**
     * @param digits a number represented as an array of digits
     * @return the result
     */
    public int[] plusOne(int[] digits) {
        // Write your code here
        List<Integer> res = new ArrayList<>();
        int plus = 1;
        for(int i=digits.length-1;i>=0;i--){
            int cur = digits[i];
            int r = cur+plus;
            res.add(r%10);
            plus = r/10;
        }
        if(plus == 1){
            res.add(1);
        }
        int[] res2 = new int[res.size()];
        int j = res.size()-1;
        for(int i=0;i<res2.length;i++){
            res2[i] = res.get(j--);
        }
        return res2;
    }
}