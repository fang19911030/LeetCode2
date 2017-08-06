public class Solution {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
     Map<String,Boolean> record = new HashMap<>();
    public boolean canJump(int[] A) {
        // wirte your code here
        return help(A, 0, A[0]);
    }
    
    private boolean help(int[] arr, int curIndex, int maxStep){
        if(curIndex+maxStep>=arr.length-1){
            return true;
        }
        String cur = String.valueOf(curIndex)+"+"+String.valueOf(maxStep);
        if(record.containsKey(cur)){
            return record.get(cur);
        }
        boolean res = false;
        for(int i=maxStep;i>0;i--){
            res = res || help(arr,curIndex+i,arr[curIndex+i]);
        }
        record.put(cur,res);
        return res;
    }
}