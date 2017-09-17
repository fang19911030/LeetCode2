class Solution {
    public int maximumSwap(int num) {
        if(num<10){
            return num;
        }
        
        List<Integer> digits = getDigit(num);
        if(isIncreased(digits)){
            return num;
        }else{
            int leftSmall = 0;
            int rightMax = 0;
            for(int i=digits.size() - 1; i>=1;i--){
                leftSmall = i;
                for(int j=0;j<i;j++){
                    if(digits.get(j) > digits.get(i) && digits.get(j) > digits.get(rightMax)){
                        rightMax = j;
                    }
                }
                if(digits.get(rightMax) > digits.get(leftSmall)) break;
            }
            Collections.swap(digits,leftSmall, rightMax);
        }
        int res = convertToNum(digits);
        return res;
    }
    private boolean isIncreased(List<Integer> digits){
        for(int i=1;i<digits.size();i++){
            if(digits.get(i)< digits.get(i-1)){
                return false;
            }
        }
        return true;
    }
    
    private List<Integer> getDigit(int num){
        List<Integer> res = new ArrayList<>();
        while(num>0){
            res.add(num % 10);
            num = num /10;
        }
        return res;
    }
    
    private int convertToNum(List<Integer> digits){
        int sum = 0;
        for(int i=digits.size()-1;i>=0;i--){
            sum = sum * 10 + digits.get(i);
        }
        return sum;
    }

    public int maximumSwap2(int num) {
        if(num<10){
            return num;
        }
        
        List<Integer> digits = getDigit(num);
        if(isIncreased(digits)){
            return num;
        }else{
            int leftSmall = 0;
            int rightMax = 0;            
            int[] rightMaxs = getRightMax(digits);
            //System.out.println(Arrays.toString(rightMaxs));
            for(int i=digits.size()-1;i>0;i--){
                rightMax = rightMaxs[i];
                leftSmall = i;
                if(digits.get(rightMax)> digits.get(i)){
                    break;
                }
            }
            Collections.swap(digits,leftSmall, rightMax);
        }
        int res = convertToNum(digits);
        return res;
    }
}