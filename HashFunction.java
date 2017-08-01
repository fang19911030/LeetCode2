
class Solution {
    /**
     * @param key: A String you should hash
     * @param HASH_SIZE: An integer
     * @return an integer
     */
    public int hashCode(char[] key,int HASH_SIZE) {
        if (key.length==0) return 0;
        int res = 0;
        int base = 33;
        for (int i=0;i<key.length;i++){
            res = modMultiply(res,base,HASH_SIZE);
            res += key[i];
            res = res % HASH_SIZE;
        }
        return res;
    }

    public int modMultiply(int a, int b, int HASH_SIZE){        
        int res = a;
        for (int j=1;j<b;j++){
            int temp = (a-HASH_SIZE);
            if (res+temp>=0)     res = res+temp;
            else res = res + a;
        }
        return res;
    }
        
}