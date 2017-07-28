public class Tower {
    private Stack<Integer> disks;
    // create three towers (i from 0 to 2)
    public Tower(int i) {
        disks = new Stack<Integer>();
    }
	

    public void add(int d) {
        if (!disks.isEmpty() && disks.peek() <= d) {
            System.out.println("Error placing disk " + d);
        } else {
            disks.push(d);
        }
    }
	

    public void moveTopTo(Tower t) {
        if(t.getDisks().size()>0 && t.getDisks().peek()<disks.peek()){
            return;
        }
        t.add(disks.pop());

    }
	
    public void moveDisks(int n, Tower destination, Tower buffer) {
        // Write your code here
        if(n == 0){
            return;
        }
        moveDisks(n - 1, buffer, destination);
        moveTopTo(destination);
        buffer.moveDisks(n - 1, destination, this);
        
    }

    public Stack<Integer> getDisks() {
        return disks;
    }
}
