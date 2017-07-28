public class Solution {  //Tle
    public boolean find132pattern(int[] nums) {
        // Write your code here
        if(nums== null || nums.length<3){
            return false;
        }
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<nums.length-1;i++){
            List<Integer> t = new ArrayList<>();
            map.put(i,t);
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]>nums[i]){
                    map.get(i).add(j);
                }
            }
        }
        for(int k=nums.length-1;k>=2;k--){
            for(Integer key: map.keySet()){
                List<Integer> list = map.get(key);
                for(int i=0;i<list.size(); i++){
                    int j = list.get(i);
                    if(k>j && k> key && nums[k]>nums[key] && nums[k]<nums[j]){
                        return true;
                    }
                }

            }
        }
        return false;
    }
    class Pair{
        int min, max;
        public Pair(int min, int max){
            this.min = min;
            this.max = max;
        }
    }
    public boolean find132pattern(int[] nums) {
        Stack<Pair> stack = new Stack();
        for(int n: nums){
            if(stack.isEmpty() || n <stack.peek().min ) stack.push(new Pair(n,n));
            else if(n > stack.peek().min){ 
                Pair last = stack.pop();
                if(n < last.max) return true;
                else {
                    last.max = n;
                    while(!stack.isEmpty() && n >= stack.peek().max) stack.pop();
                    // At this time, n < stack.peek().max (if stack not empty)
                    if(!stack.isEmpty() && stack.peek().min < n) return true;
                    stack.push(last);
                }
                
            }
        }
        return false;
    }
}