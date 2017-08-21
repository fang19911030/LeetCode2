import java.util.*;
public class LargestDivisbleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        // Write your code here
        if(nums == null || nums.length == 0){
            return new ArrayList<Integer>();
        }
        if(nums.length == 1){
            List<Integer> res = new ArrayList<>();
            res.add(nums[0]);
            return res;
        }
        List<Integer>[] res = (List<Integer>[]) new List[nums.length];

        Arrays.sort(nums);

        res[0] = new ArrayList<>();
        res[0].add(nums[0]);

        for(int i=1;i<nums.length;i++){
            for(int j=i-1;j>=0;j--){
                if(nums[i] % nums[j] == 0){
                    List<Integer> cur = new ArrayList<>(res[j]);
                    cur.add(nums[i]);
                    if(res[i] == null){
                        res[i] = cur;
                    }else{
                        if(cur.size()>res[i].size()){
                            res[i] = cur;
                        }
                    }
                }
            }
            if(res[i] == null){
                res[i] = new ArrayList<>();
                res[i].add(nums[i]);
            }
        }
        List<Integer> r = null;
        for(int i=1;i<res.length;i++){
            if(r == null){
                r = res[i];
            }else{
                if(res[i].size()>r.size()){
                    r = res[i];
                }
            }
        }
        return r;
    }