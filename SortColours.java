class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        // write your code here
        int a = -1;
        int b = nums.length;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                a++;
                swap(nums, a, i);
            }
        }
        for(int i=a+1;i<b;i++){
            if(nums[i] == 1){
                a++;
                swap(nums,a,i);
            }
        }
        
    }

    public void sortColors(int[] nums) {
        // write your code here
        int n1 = -1, n2 = -1, n3= -1;
        int[] A =nums;
        for(int i=0;i<nums.length;i++){
            if(A[i] == 0){
                A[++n1] = 2;
                A[++n2] = 1;
                A[++n3] = 0;
            }else if(A[i] == 1){
                A[++n1] = 2;
                A[++n2] = 1;
            }else{
                A[++n1] = 2;
            }
    }
       
    
    private void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


}