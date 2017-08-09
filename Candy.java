public class Solution {
    /**
     * @param ratings Children's ratings
     * @return the minimum candies you must give
     */
    public int candy(int[] ratings) {
        // Write your code here
        int[] record = new int[ratings.length];
        int i = 0;
        int res = 0;
        if(ratings == null || ratings.length<=1){
            return 1;
        }
        int length = ratings.length;
        
        while(i<ratings.length-1){
            if(ratings[i] == ratings[i+1]){
                if(record[i] == 0) record[i] = 1;
                int j = i+1;
                while(j<ratings.length && ratings[j] == ratings[i]){
                    record[j] = 1;
                    j++;
                }
                i = j-1;
            }else if(ratings[i]<ratings[i+1]){
                if(record[i] == 0) record[i] =1;
                int j = i+1;
                while(j<length && ratings[j]> ratings[j-1]){
                    record[j] = record[j-1]+1;
                    j++;
                }
                i = j-1;
            }else{
                int j = i+1;
                int smallend = i;
                while(j<length && ratings[j]< ratings[j-1]){
                    smallend = j;
                    j++;
                }
                record[smallend--] = 1;
                while(smallend>=i){
                    if(record[smallend] == 0){
                        record[smallend] = record[smallend+1]+1;
                    }else{
                        record[smallend] = Math.max(record[smallend], record[smallend+1]+1);
                    }
                    smallend--;
                }
                i = j-1;
            }
        }
        for(int j=0;j<record.length;j++){
            res += record[j];
        }
        return res;
    }
}