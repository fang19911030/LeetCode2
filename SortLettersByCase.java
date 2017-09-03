public class Solution {
    /** 
     *@param chars: The letter array you should sort by Case
     *@return: void
     */
    public void sortLetters(char[] chars) {
        //write your code here
        int[]count = new int[52];
        for(int i=0;i<chars.length;i++){
            char cur = chars[i];
            if(Character.isUpperCase(cur)){
                int idx = cur-'A'+26;
                count[idx]++;
            }else{
                int idx = cur-'a';
                count[idx]++;
            }
        }
        for(int i=1;i<count.length;i++){
            count[i] = count[i] + count[i-1];
        }
        char[] res = new char[chars.length];
        for(int i=0;i<chars.length;i++){
            char cur = chars[i];
            if(Character.isUpperCase(cur)){
                int idx = cur-'A'+26;
                res[count[idx]-1] = chars[i];
                count[idx]--;
            }else{
                int idx = cur-'a';
                res[count[idx]-1] = chars[i];
                count[idx]--;
            }
        }
        for(int i=0;i<res.length;i++){
            chars[i] = res[i];
        }
    }
}