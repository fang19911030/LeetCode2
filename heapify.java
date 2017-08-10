public class Solution {
    /**
     * @param A: Given an integer array
     * @return: void
     */
    public void heapify(int[] A) {
        // write your code here
        for(int i=A.length/2;i>=0;i--){
            minHeapify(A, i);
        }
    }
    
    private void minHeapify(int[] A, int index){
        int left = 2*index+1;
        int right = 2*index+2;
        int small = index;
        while(left<A.length){
            if(A[left]<A[index]){
                small = left;
            }
            if(right<A.length && A[right]<A[small]){
                small = right;
            }
            if(small == index){
                break;
            }else{
                swap(A,small, index);
            }
            index = small;
            left = 2*index+1;
            right = 2*index+2;
        }
    }
    
    private void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}