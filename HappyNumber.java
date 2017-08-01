public class Solution {
    public boolean isHappy(int n) {
        // Write your code here
        int[] squ = new int[10];
        for(int i=0;i<squ.length;i++){
            squ[i] = i*i;
        }
        List<Integer> digits = new LinkedList<>();
        while(n!=0){
            int d = n%10;
            digits.add(0,d);
            n = n/10;
        }
        return help(digits,squ,false);
    }
    
    private boolean help(List<Integer> list, int[] arr,boolean flag){
        int sum = 0;
        for(int i=0;i<list.size();i++){
            sum += arr[list.get(i)];
        }
        boolean res = false;
        if(sum == 1){
            res = true;
            return res;
        }else if(sum<10 || sum==0){
            if(flag == false){
                List<Integer> next = new LinkedList<>();
                while(sum != 0){
                    int d= sum%10;
                    next.add(0,d);
                    sum = sum/10;
                }
                return res = res || help(next, arr, true);
            }else{
                return false;
            }
        }else{
            List<Integer> next = new LinkedList<>();
            while(sum != 0){
                int d= sum%10;
                next.add(0,d);
                sum = sum/10;
            }
            return res = res || help(next, arr,flag);
        }
    }
}