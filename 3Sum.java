public class Solution {
    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(numbers == null || numbers.length<=2){
            return res;
        }
        Arrays.sort(numbers);
        int i=0;
        while(i<numbers.length-2){
            int a = numbers[i];
            int j = i+1;
            while(j<numbers.length-1){
                int target = 0-a-numbers[j];
                int indexC = search(numbers, target, j+1);
                if(indexC!= -1){
                    ArrayList<Integer> tmp = new ArrayList<>();
                    tmp.add(a);
                    tmp.add(numbers[j]);
                    tmp.add(numbers[indexC]);
                    res.add(tmp);
                }
                while(j<numbers.length-1 && numbers[j] == numbers[j+1]){
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
    
    private int search(int[] arr, int target, int left){
        int l = left;
        int r = arr.length-1;
        while(l<=r){
            int mid = l +(r-l)/2;
            if(arr[mid]>target){
                r = mid-1;
            }else if(arr[mid]<target){
                l = mid+1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}