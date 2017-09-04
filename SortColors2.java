class Solution {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        // write your code here
        int[]arr = colors;
        int min=1;
        int max = k;
        int pl = 0;
        int pr= colors.length-1;
        int i = 0;
        while(min<max){
            while(i<=pr){
                if(arr[i] == min){
                    swap(arr,i,pl);
                    pl++;
                    i++;
                }else if(arr[i] == max){
                    swap(arr,i,pr);
                    pr--;
                }else{
                    i++;
                }
            }
            min++;
            max--;
            i=pl;
        }
    }
    
    private void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}