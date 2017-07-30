public class MinStack {
    Deque<Integer> stack;
    Deque<Integer> min;
    int small;
    
    public MinStack() {
        // do initialize if necessary
        stack = new ArrayDeque<>();
        min = new ArrayDeque<>();
        min.push(Integer.MAX_VALUE);
    }

    public void push(int number) {
        // write your code here
        stack.push(number);
        if(number<min.peek()){
            min.push(number);
        }else{
            min.push(min.peek());
        }
    }

    public int pop() {
        // write your code here
        min.pop();
        return stack.pop();
    }

    public int min() {

        return min.peek();
    }
}