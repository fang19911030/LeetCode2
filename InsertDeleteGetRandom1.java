public class RandomizedSet {
    Map<Integer, Integer> map;
    List<Integer> list;
    Random rand;

    public RandomizedSet() {
        // do initialize if necessary
        list = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }
    
    // Inserts a value to the set
    // Returns true if the set did not already contain the specified element or false
    public boolean insert(int val) {
        // Write your code here
        if(map.containsKey(val)){
            return false;
        }
        list.add(val);
        map.put(val,list.size());
        return true;
    }
    
    // Removes a value from the set
    // Return true if the set contained the specified element or false
    public boolean remove(int val) {
        // Write your code here
        if(!map.containsKey(val)){
            return false;
        }
        int index = map.get(val);
        if(index == list.size()){
            list.remove(index-1);
            map.remove(val);
        }else{
            int last = list.get(list.size()-1);
            list.set(index-1,last);
            map.put(last,index);
            map.remove(val);
            list.remove(list.size()-1);
        }
        return true;
        
    }
    
    // Get a random element from the set
    public int getRandom() {
        // Write your code here
        int index = rand.nextInt(list.size());
        return list.get(index);
        
    }
}