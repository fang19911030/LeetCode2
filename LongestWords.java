class Solution {
    /**
     * @param dictionary: an array of strings
     * @return: an arraylist of strings
     */
    ArrayList<String> longestWords(String[] dictionary) {
        // write your code here
        int max = 0;
        ArrayList<String> res = new ArrayList<>();
        if(dictionary==null || dictionary.length == 0){
            return res;
        }
        for(int i=0;i<dictionary.length;i++){
            String cur = dictionary[i];
            if(cur.length()>max){
                max = cur.length();
                ArrayList<String> t = new ArrayList<>();
                t.add(cur);
                res = t;
            }else if(cur.length() == max){
                res.add(cur);
            }
        }
        return res;
    }
};