public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target : An integer
     * @return : return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers, int target) {
        // write your code here
        
        Arrays.sort(numbers);
        int i=0;
        int res = Integer.MAX_VALUE;
        while(i<numbers.length-2){
            int a = numbers[i];
            int j = i+1;
            while(j <numbers.length-1){
                int b = numbers[j];
                int indexC = search(numbers,j+1,target-a-b);
                int sum = a+b+numbers[indexC];
                if(Math.abs(sum-target)<Math.abs(res-target)){
                    res = sum;
                }
                while( j<numbers.length-1 && numbers[j]== numbers[j+1]){
                    j++;
                }
                j++;
            }
            while(i<numbers.length-1 && numbers[i] == numbers[i+1]){
                i++;
            }
            i++;
        }
        return res;
    }
    
    private int search(int[] arr, int left, int target){
        int l = left;
        int r = arr.length-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(target>arr[mid]){
                l = mid+1;
            }else if(target<arr[mid]){
                r = mid-1;
            }else{
                return mid;
            }
        }
        if(left<=l && l<arr.length && r>=left && r<arr.length){
            if(Math.abs(arr[l]-target)<Math.abs(arr[r]-target)){
                return l;
            }else{
                return r;
            }
        }else if(l>=left && l<arr.length){
            return l;
        }else{
            return r;
        }
    }
}
