class AllOne {
    private Bucket head;
    private Bucket tail;
    
    private Map<Integer,Bucket>countBucketMap;
    private Map<String, Integer>keyCountMap;
    
    private class Bucket{
        int count;
        Set<String> keySet;
        Bucket next;
        Bucket pre;
        public Bucket(int cnt){
            count = cnt;
            keySet = new HashSet<>();
        }
        
        public List<String> getKeyList(){
            return new ArrayList<String>(keySet);
        }
    }

    /** Initialize your data structure here. */
    public AllOne() {
        head = new Bucket(Integer.MIN_VALUE);
        tail = new Bucket(Integer.MIN_VALUE);
        head.pre = null;
        head.next = tail;
        tail.pre = head;
        tail.next = null;
        countBucketMap = new HashMap<>();
        keyCountMap = new HashMap<>();
        
    }
    
    private void addToHead(Bucket newBucket){
        Bucket oldNext = head.next;
        head.next = newBucket;
        newBucket.pre = head;
        newBucket.next = oldNext;
        oldNext.pre = newBucket;
        
    }
    
    private void removeBucket(Bucket remove){
        Bucket next = remove.next;
        Bucket pre = remove.pre;
        pre.next = next;
        next.pre = pre;
        remove.next = null;
        remove.pre = null;
    }
    
    private void removeKeyFromBucket(Bucket t, String key){
        t.keySet.remove(key);
        if(t.keySet.size() == 0){
            int c = t.count;
            removeBucket(t);
            countBucketMap.remove(c);
        }
    }
    
    private void addBucketAfter(Bucket pre, Bucket cur){
        Bucket preNext = pre.next;
        pre.next = cur;
        cur.pre = pre;
        cur.next = preNext;
        preNext.pre = cur;
    }
    
    private void addKeyToBucket(String key, int count, Bucket pre){
          if(pre.count<=count){
              if(countBucketMap.containsKey(count)){
                  countBucketMap.get(count).keySet.add(key);
              }else{
                  Bucket newBucket = new Bucket(count);
                  newBucket.keySet.add(key);
                  countBucketMap.put(count, newBucket);
                  addBucketAfter(pre, newBucket);
              }
          }else{
              if(countBucketMap.containsKey(count)){
                  countBucketMap.get(count).keySet.add(key);
              }else{
                  Bucket newBucket = new Bucket(count);
                  newBucket.keySet.add(key);
                  countBucketMap.put(count, newBucket);
                  addBucketAfter(pre.pre,newBucket);
              }
          }
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if(!keyCountMap.containsKey(key)){
            keyCountMap.put(key,1);
            addKeyToBucket(key,1,head);
        }else{
            int count = keyCountMap.get(key);
            keyCountMap.put(key,count+1);
            Bucket old = countBucketMap.get(count);
            addKeyToBucket(key,count+1,old);
            removeKeyFromBucket(old, key);

        }
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if( !keyCountMap.containsKey(key)){
            return;
        }
        int count = keyCountMap.get(key);
        if(count == 1){
            keyCountMap.remove(key);
            Bucket t = countBucketMap.get(1);
            removeKeyFromBucket(t, key);
        }else{
            Bucket t = countBucketMap.get(count);
            addKeyToBucket(key, count-1,t.pre);
            removeKeyFromBucket(t, key);
            keyCountMap.put(key,count-1);
        }
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if(head.next == tail){
            return "";
        }
        return tail.pre.keySet.iterator().next();
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if(head.next == tail){
            return "";
        }
        return head.next.keySet.iterator().next();
    }
}