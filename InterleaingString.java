public class Solution {
    /**
     * Determine whether s3 is formed by interleaving of s1 and s2.
     * @param s1, s2, s3: As description.
     * @return: true or false.
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        // write your code here
        if(s3 == null){
            return true;
        }
        if(s1 == null){
            return s2.equals(s3);
        }
        if(s2 == null){
            return s1.equals(s3);
        }
        
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        char[]str3 = s3.toCharArray();
        if(str3.length!= str1.length+str2.length){
            return false;
        }
        
        return help(str1, str2, str3, 0,0,0);
    }
    
    private boolean help(char[] str1, char[] str2, char[] str3, int i, int j, int k){
        if(k==str3.length){
            return true;
        }
        boolean res = false;
        if(i<str1.length && j<str2.length){
            if(str3[k]!=str1[i] && str3[k] != str2[j]){
                return res;
            }
            if(str3[k]==str1[i] && str3[k] != str2[j]){
                res = res || help(str1,str2, str3,i+1,j,k+1);
            }
            if(str3[k] == str2[j] && str3[k] != str1[i]){
                res = res|| help(str1,str2,str3,i,j+1,k+1);
            }
            if(str3[k] == str1[i] && str3[k] == str2[j]){
                res = res || help(str1,str2,str3,i+1,j,k+1) || help(str1,str2,str3,i,j+1,k+1);
            }
            return res;
        }else if(j>=str2.length){
            if(str1[i] != str3[k]){
                return false;
            }else{
                res = res || help(str1,str2,str3,i+1,j,k+1);
            }
            return res;
        }else{
            if(str2[j] != str3[k]){
                return false;
            }else{
                res = res || help(str1, str2,str3,i,j+1,k+1);
            }
            return res;
        }

    }
}