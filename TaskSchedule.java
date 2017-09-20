class Solution {
    public int leastInterval(char[] tasks, int n) {
        if(tasks == null || tasks.length == 0){
            return 0;
        }
        if(n==0){
            return tasks.length;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<tasks.length;i++){
            map.put(tasks[i], map.getOrDefault(tasks[i],0)+1);
        }
        
        PriorityQueue<Map.Entry<Character,Integer>> pq = new PriorityQueue<>(
        (a,b)-> a.getValue() != b.getValue()? b.getValue()-a.getValue():a.getKey() - b.getKey()
        );
        
        pq.addAll(map.entrySet());
        int count = 0;
        while(!pq.isEmpty()){
            int k = n+1;
            List<Map.Entry<Character, Integer>> tempList = new ArrayList<>();
            while(k > 0 && !pq.isEmpty()){
                Map.Entry<Character,Integer> curTask = pq.poll();
                curTask.setValue(curTask.getValue() - 1);
                if(curTask.getValue()>0){
                    tempList.add(curTask);
                }
                k--;
                count++;
            }
            for(int i=0;i<tempList.size();i++){
                pq.offer(tempList.get(i));
            }
            if(pq.isEmpty()) break;
            count += k;
        }
        return count;
    }
}