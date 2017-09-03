This question can use max heap to solve it.

class Solution {
    /*
     * @param k : description of k
     * @param nums : array of nums
     * @return: description of return
     */
    public int kthLargestElement(int k, int[] nums) {
        
        return help(nums.length-k+1, nums, 0, nums.length-1);
    }
    
    private int help(int k, int[] arr, int left, int right){
        if(left == right){
            return arr[left];
        }
        int idx = partition(arr,left,right);
        if(idx+1 == k){
            return arr[idx];
        }else if(idx+1 >k){
            return help(k,arr,left,idx-1);
        }else{
            return help(k,arr,idx+1,right);
        }
    }
    
    private int partition(int[] arr, int l, int r){
        int pivot = arr[r];
        int idx = l-1;
        for(int i=l;i<r;i++){
            if(arr[i]<=pivot){
                idx++;
                swap(arr, i, idx);
            }
        }
        swap(arr, r,idx+1);
        return idx+1;
        
    }
    
    private void swap(int[] a , int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
};
