

public class Solution {
    /*
     * @param n: the nth
     * @return: the nth sequence
     */
    public String countAndSay(int n) {
        // write your code here
        String str ="1";
        if(n==1){
            return str;
        }
        int i=1;
        while(i<n){
            StringBuilder sb = new StringBuilder();
            int j = str.length()-1;
            while(j>=0){
                char cur = str.charAt(j);
                int k=0;
                int t = j;
                while(t>=0 && str.charAt(t) == cur){
                    t--;
                    k++;
                }
                j=t;
                sb.insert(0,cur);
                sb.insert(0,k);
            }
            str = sb.toString();
            i++;
        }
        return str;
    }
}