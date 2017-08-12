import java.util.Arrays;
import java.util.Collections;
import java.util.TreeMap;

/**
 * Created by fang on 8/12/17.
 */
public class DataStreamMedian {

    public int[] medianII(int[] nums) {
        // write your code here

        TreeMap<Integer, Integer> minHeap = new TreeMap<>();
        TreeMap<Integer, Integer> maxHeap = new TreeMap<>(Collections.reverseOrder());
        int minSize = 0, maxSize = 0 ;
        int[] res = new int[nums.length];
        int index = 0;
        for(Integer cur:nums){
            int minHeapTop = minHeap.firstEntry()==null? Integer.MIN_VALUE: minHeap.firstKey();
            int maxHeapTop = maxHeap.firstEntry()==null? Integer.MAX_VALUE: maxHeap.firstKey();

            if(cur<=maxHeapTop){
                if(maxHeap.containsKey(cur)){
                    maxHeap.put(cur,maxHeap.get(cur)+1);
                }else{
                    maxHeap.put(cur,1);
                }
                maxSize++;
            }else{
                if(minHeap.containsKey(cur)){
                    minHeap.put(cur,minHeap.get(cur)+1);
                }else{
                    minHeap.put(cur,1);
                }
                minSize++;

            }

            if(maxSize-1>minSize){
                heapTransfer(maxHeap,minHeap);
                maxSize--;
                minSize++;
            }else if(minSize-1>maxSize){
                heapTransfer(minHeap,maxHeap);
                minSize--;
                maxSize++;
            }
            if(maxSize == minSize){
                res[index++] = maxHeap.firstKey();
            }else{
                if(minSize == 0){
                    res[index++] = maxHeap.firstKey();
                }else{
                    res[index++] = minSize>maxSize? minHeap.firstKey():maxHeap.firstKey();
                }
            }
        }
        return res;
    }

    private void heapTransfer(TreeMap<Integer, Integer> a, TreeMap<Integer,Integer> b){
        Integer key = a.firstKey();
        if(b.containsKey(key)){
            b.put(key,b.get(key)+1);
        }else{
            b.put(key,1);
        }

        if(a.get(key)==1){
            a.remove(key);
        }else{
            a.put(key,a.get(key)-1);
        }
    }


    public static void main(String[] args){
        int[] a ={1,2,3,4,5};
        DataStreamMedian test = new DataStreamMedian();
        int[] res = test.medianII(a);
        System.out.println(Arrays.toString(res));
    }
}